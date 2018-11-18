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
  
  <script type="text/javascript" charset="utf-8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
  
  <div class="content-wrapper">
  <div class="content">
      <div class="box">
          <div class="box-header with-border">
              <h1 class="box-title">Point History</h1>
          </div>
          <div class="box-body">
              <table id="notification_table" class="table table-striped table-bordered" style="width:100%">
          <thead>
              <tr>
                  <td class="hidden">Time</td>
                  <td>User</td>
                  <td>Description</td>
                  <td>Point</td>
              </tr>
          </thead>
          <tbody>
              <c:forEach items="${transactions}" var="value">
              <tr>
                  <td class="hidden">${value.tranTime}</td>
                  <td>
                      <div class="row">
                          <div class="col-sm-4">
                              <img src="/images/users/${value.tblMpUser.profilePic}" class="img-circle center-block img-responsive" style="height:40px; width:40px;">
                          </div>
                          <div class="col-sm-8 text-left">
	                          <b>${value.tblMpUser.firstName} ${value.tblMpUser.lastName}</b><br>
	                          <c:if test = "${not empty value.tblMpUser.emailId}">
	                          	<a href="mailto:${value.tblMpUser.emailId}">${value.tblMpUser.emailId}</a><br>
	                      	  </c:if>
	                          <c:if test = "${not empty value.tblMpUser.phoneNo}">
	                    		<a href="tel:${value.tblMpUser.phoneNo}">${value.tblMpUser.phoneNo}</a><br>
	                    	  </c:if>
                    	  </div>
                      </div>
                  </td>
                  <td>
                      ${value.tranDescription}
                  </td>
                  <td>
                      ${value.tranType == 1 ? "+ " : "- "} ${value.tranPoint}
                  </td>
              </tr>
              </c:forEach>
          </tbody>
      </table>
          </div>
      </div>
  </div>
</div>


<script type="text/javascript" src="/js/custom/transaction.js"></script>

<jsp:include page='footer.jsp' />
