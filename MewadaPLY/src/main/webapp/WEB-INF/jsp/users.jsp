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
  <div class="content-header">
      <h1>Users</h1>
  </div>
  <section class="content">
      <div class="content box">
          <table id="user_table" class="table table-striped table-bordered" style="width:100%">
              <thead>
                  <tr>
                       <th>Profile</th>
                  	   <th>Name</th>
                      <th>Address</th>
                      <th>City</th>
                      <th>Reward Points</th>
                      <th>Redeem Points</th>
                      <th>Point Left</th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach items="${users}" var="value">
                  <tr>
                  	  <td>    <img src="/images/users/${value.profilePic}" class="img-circle center-block img-responsive" style="height:40px; width:40px;"></td>
                      <td>
                          <div class="row">
                              <div class="col-xs-12">
                                  <b>${value.firstName} ${value.lastName}</b><br>
                                  <c:if test = "${not empty value.emailId}">
                                	<a href="mailto:${value.emailId}">${value.emailId}</a><br>
                                  </c:if>
                                  <c:if test = "${not empty value.phoneNo}">
                              		<a href="tel:${value.phoneNo}">${value.phoneNo}</a><br>
                              	  </c:if>
                              </div>
                          </div>
                      </td>
                      <td>
                          ${value.addressLine1}<br>${value.addressLine2}
                      </td>
                      <td>${value.city}</td>
                      <td>
                          ${value.pointEarned}
                      </td>
                      <td>
                      	 ${value.pointRedeem}
                      </td>
                      <td>
                        ${value.pointEarned - value.pointRedeem} 
                      </td>
                  </tr>
                  </c:forEach>
              </tbody>
              <tfoot>
                  <tr>
					<th>Profile</th>
					<th>Name</th>
	                 <th>Address</th>
	                 <th>City</th>
	                 <th>Reward Points</th>
	                 <th>Redeem Points</th>
	                 <th>Point Left</th>
                  </tr>
              </tfoot>
          </table>
      </div>
  </section>
</div>

<script type="text/javascript" src="/js/custom/users.js"></script>

<jsp:include page='footer.jsp' />
