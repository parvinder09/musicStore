<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
       <div id="login-box">
           <h2>Login with username and password</h2>
            <c:if test="${not empty msg}">
                <div class="msg" style="color:red">${msg}</div>
            </c:if>
           <form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">
               <c:if test="${not empty error}">
                   <div class="error" style="color:red">${error}</div>
               </c:if>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
               <div class="form-group">
                   <label for="password">Password:</label>
                   <input type="password" id="password" name="password" class="form-control"/>
               </div>
               <input type="submit" value="Submit" class="btn btn-default"/>
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           </form>
       </div>




        <%@include file="/WEB-INF/views/template/footer.jsp"%>
    </div>
</div>
