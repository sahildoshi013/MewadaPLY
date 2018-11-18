<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Mewada Ply | Admin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

  
  <jsp:include page='header.jsp'>
  	<jsp:param name="page" value="${page}"/>
  </jsp:include>
  
  <style type="text/css">
  .box.box-primary{
      border-top-color: black;
  }
  .btn-primary{
      background-color: black;
      border-color: black;
  }
  .btn-primary:hover, .btn-primary:active, .btn-primary.hover {
      background-color: white;
      color: black;
  }
  .btn-link{
      color: black;
  }

  pre {
     white-space: pre-wrap;       /* css-3 */
     white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
     white-space: -pre-wrap;      /* Opera 4-6 */
     white-space: -o-pre-wrap;    /* Opera 7 */
     word-wrap: break-word;       /* Internet Explorer 5.5+ */
 }
</style>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <section class="content-header">
      <h1>
          Feedbacks
      </h1>
  </section>

  <div class="clearfix"></div>

  <section class="content">
  	<c:forEach items="${feedback}" var="value">
          <div class="row">
              <div class="col-md-12">
                  <div class="box box-primary">
                      <div class="box-body">
                          <div class="col-md-3 text-center">
                              <img class="profile-user-img img-responsive img-circle" src="/images/users/${value.tblMpUser.profilePic}" alt="offer image" style="height: 100px;">
                              <h3 class="profile-username">${value.tblMpUser.firstName} ${value.tblMpUser.lastName}</h3>
                              <c:if test = "${not empty value.tblMpUser.emailId}">
                          	<a href="mailto:${value.tblMpUser.emailId}">${value.tblMpUser.emailId}</a><br>
                            </c:if>
                            <c:if test = "${not empty value.tblMpUser.phoneNo}">
                        		<a href="tel:${value.tblMpUser.phoneNo}">${value.tblMpUser.phoneNo}</a><br>
                        	  </c:if>
                          </div>
                          <div class="col-md-9">
                              <p> <b>${value.feedbackSubject}</b></p>
                              <pre>${value.feedbackMessage}</pre>
                              </div>
                      </div>
                  </div>
              </div>
          </div>
      </c:forEach>
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<!--<script type="text/javascript" src="/js/custom/users.js"></script>-->

<jsp:include page='footer.jsp' />
