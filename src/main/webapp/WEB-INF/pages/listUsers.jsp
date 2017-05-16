    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ page import="Model.TblAccount" %>
        <!DOCTYPE html>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        </head>
        <body>
        <h1>TutorialsPeida JSP Hibernate Example!</h1>
        <div style="background-color: #FFBBCC; width:40%;">
        <br />
        <h2>Account Search Form</h2>
        <form name="searchForm" action="searchController">
        Enter Account ID:<input type="text" name="searchValue" value="" >
        <input type="submit" value="Find Account Details>>" name="searchButton" />
        </form>
            <% TblAccount acc= (TblAccount) request.getAttribute("searchResult");

        if (acc !=null)
                {

               %>
        <table border="1">

        <tbody>
        <tr>
        <td>Account ID</td>
        <td><% out.println(acc.getAccountId()); %></td>
        </tr>
        <tr>
        <td>Account Title</td>
        <td><% out.println(acc.getAccountBeneficiary()); %></td>
        </tr>
        <tr>
        <td>Account Balance</td>
        <td><% out.println(acc.getAccountBalance()); %></td>
        </tr>
        <tr>
        <td>Account Type</td>
        <td><% out.println(acc.getAccountType()); %></td>
        </tr>
        </tbody>
        </table>

            <%
                       }


          %>
        <br /><br /><br />
        </div>
        <br /><br /><br />
        <div style="background-color: #FFBBCC; width:40%;">
        <br />
        <h2>Account Creation Form</h2>
        <form name="addForm" action="AddAccountController"><br />
        <table>
        <tr><td>Account ID:</td><td><input type="text" name="AccountID" value="" /></td></tr>
        <tr><td>Account Title:<td><input type="text" name="AccountTitle" value="" /></td></tr>
        <tr><td>Account Balance:<td><input type="text" name="AccountBalance" value="" /></td></tr>
        <tr><td> Account Type: <td>  <input type="text" name="AccountType" value="" /></td></tr>

        <tr><td></td><td><input type="submit" value="submitButton" /> </td></tr>
        </table>
        </form>
        <h2>
            <%
            String rMessage=request.getParameter("message");
            if (rMessage==null)
            rMessage="";
                out.println(rMessage);

            %>
        </h2>
        <br /><br /><br />
        </div>



        </body>
        </html>