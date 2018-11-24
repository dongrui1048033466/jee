package com.drsoft.JEE.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Map;

public class NavigationTag extends TagSupport {
    static final long serialVersionUID = 2372405317744358833L;
    //获取Page对象实例的名称
    private String bean = "page";
    //分页跳转的url地址
    private String url = null;
    //显示页码的数量
    private int number = 5;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //为url添加参数对
    private String append(String url,String key,String value){
        if(url==null||url.trim().length()==0){
            return "";
        }

        if(url.indexOf("?")==-1){
            url += "?" + key + "=" + value;
        }else{
            if(url.endsWith("?")){
                url += key + "=" + value;
            }else{
                url += "&amp;" + key + "=" + value;
            }
        }
        return url;
    }

    private String append(String url,String key,int value){
        return append(url,key,String.valueOf(value));
    }


    //为url添加翻页请求参数
    private String resolveUrl(String url, PageContext pageContext){
        Map params = pageContext.getRequest().getParameterMap();

        for(Object key:params.keySet()){
            if("page".equals(key)||"rows".equals(key)){
                continue;
            }

            Object value = params.get(key);

            if(value == null){
                continue;
            }

            if(value.getClass().isArray()){
                url = append(url,key.toString(),((String[])value)[0]);
            }else if (value instanceof String){
                url = append(url,key.toString(),value.toString());
            }
        }
        return url;
    }



    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();

        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

        Page page = (Page)request.getAttribute(bean);

        if(page == null)
            return SKIP_BODY;

        url = resolveUrl(url,pageContext);

        try{

            //计算总页数
            int pageCount = page.getTotal()/page.getSize();

            if(page.getTotal()%page.getSize() > 0){
                pageCount++;
            }
            //<nav><ul class="pagination">
            writer.print("<nav><ul class=\"pagination\">");

            //首页链接路径
            String homeUrl = append(url,"page",1);
            //末页的链接路径
            String backUrl = append(url,"page",pageCount);

            //显示首页和上一页
            if(page.getPage()>1){
                //当前页前一页的Url
                String preUrl = append(url,"page",page.getPage()-1);
                preUrl = append(preUrl,"rows",page.getSize());

                //输出html代码
                writer.print("<li><a href=\"" + homeUrl + "\">首页</a></li>");
                writer.print("<li><a href=\"" + preUrl + "\">上一页</a></li>");
            }else{
                writer.print("<li class=\"disabled\"><a href=\"#\">首页</a></li>");
                writer.print("<li class=\"disabled\"><a href=\"#\">上一页</a></li>");
            }

            //显示当前页码的前两个页码和后两个页码
            //10,8 9 10 11 12
            int indexPage;
            if(page.getPage() - 2 <=0){
                //当前页面为1或2
                indexPage = 1;
            }else if(pageCount-page.getPage() <=2){
                //剩余页少于等于2的时候
                indexPage = pageCount - 4;
            }else{
                indexPage = page.getPage() - 2;
            }

            for(int i=1;i<=number&&indexPage<=pageCount;indexPage++,i++){
                if(indexPage == page.getPage()){
                    writer.print("<li class=\"active\"><a href=\"#\">" +
                            indexPage +"<span class=\"sr-only\">(current)</span></a></li>");
                    continue;
                }

                String pageUrl = append(url,"page",indexPage);
                pageUrl = append(pageUrl,"rows",page.getSize());

                writer.print("<li><a href=\"" + pageUrl + "\">" + indexPage + "</a></li>");
            }

            //显示下一页和尾页
            if(page.getPage()<pageCount){
                String nextUrl = append(url,"page",page.getPage() + 1);
                nextUrl = append(nextUrl,"rows",page.getSize());

                writer.print("<li><a href=\"" + nextUrl + "\">下一页</a></li>");
                writer.print("<li><a href=\"" + backUrl + "\">尾页</a></li>");
            }else{
                writer.print("<li class=\"disabled\"><a href=\"#\">下一页</a></li>");
                writer.print("<li class=\"disabled\"><a href=\"#\">尾页</a></li>");
            }

            writer.print("</ul></nav>");

        }catch (IOException e){
            e.printStackTrace();
        }

        return SKIP_BODY;


    }
}
