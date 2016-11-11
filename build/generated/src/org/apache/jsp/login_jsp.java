package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("        <meta name=\"description\" content=\"Enterprise resource management system IT staff portal\">\n");
      out.write("        <meta name=\"author\" content=\"SOEN 387 team #5\">\n");
      out.write("        <link rel=\"icon\" href=\"images/favicon.ico\"> <!-- downloaded from freefavicon.com -->\n");
      out.write("\n");
      out.write("        <title>ERM</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this page -->\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body id=\"login-page\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"login-page-content\">\n");
      out.write("                <h1 id=\"dashboard\">ERM IT Staff Log In</h1>\n");
      out.write("                \n");
      out.write("                <form method=\"post\" action=\"index.jsp\">\n");
      out.write("                    <div class=\"form-group row\">\n");
      out.write("                        <label for=\"ITstaffAccount\" class=\"col-lg-2\"><h4>Account</h4></label>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"ITstaffAccount\" name=\"account\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>  \n");
      out.write("                    <div class=\"form-group row\">\n");
      out.write("                        <label for=\"ITstaffPassword\" class=\"col-lg-2\"><h4>Password</h4></label>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"ITstaffPassword\" name=\"password\">\n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"form-group row\">\n");
      out.write("                        <div class=\"col-lg-2\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" name=\"login\">Log In</button> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- if the user or password were incorrect, an error message is displayed -->\n");
      out.write("                    ");
 if (!session.isNew() && session.getAttribute("validLogin").equals("false")) { 
      out.write(" \n");
      out.write("                    <div id=\"login-messages\">\n");
      out.write("                        <div class=\"alert alert-danger\" role=\"alert\">Invalid user or password.</div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div><!-- /.container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write(" <!-- Bootstrap JavaScript and closing tags -->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}