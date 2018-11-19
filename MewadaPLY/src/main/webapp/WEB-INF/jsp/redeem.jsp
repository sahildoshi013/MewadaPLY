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
      <h1>Redeem Points</h1>
  </div>
  <div class="content">
      <div class="row">
          <div class="col-lg-12">
              <div class="box">
                  <div class="box-header with-border">
                      <h3 class="box-title">Pending Requests</h3>
                  </div>
                  <div class="box-body">
                      <table id="pending_requests_table" class="table table-striped table-bordered" style="width:100%">
                          <thead>
                              <tr>
                                  <td>Name</td>
                                  <td>Offer</td>
                                  <td>Action</td>
                              </tr>
                          </thead>
                          <tbody>
                          		<c:forEach items="${pending_requests}" var="value">
                              <tr>
                                  <td>
                                      <div class="row">
                                          <div class="col-xs-2">
                                              <img src="/images/users/${value.tblMpUser.profilePic}" class="img-circle center-block img-responsive" style="height:40px; width:40px;">
                                          </div>
                                          <div class="col-xs-10">
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
                                      <div class="row">
                                          <div class="col-xs-2">
                                              <img src="/images/offers/${value.tblMpRedeemOffers.offerImage}" class="img-circle center-block img-responsive" style="height:40px; width:40px;">
                                          </div>
                                          <div class="col-xs-10">
                                              <b>${value.tblMpRedeemOffers.offerName}</b><br>
                                              ${value.tblMpRedeemOffers.offerDescription}<br><br>
                                              <b>Points : </b>${value.tblMpRedeemOffers.offerPoint}
                                          </div>
                                      </div>
                                  </td>
                                  <td>
                                      <div class="btn-group" role="group" aria-label="Action">
                                          <button type="button" class="btn btn-default" onclick="update_request(event,${value.requestId},1)">Accept</button>
                                          <button type="button" class="btn btn-default" onclick="update_request(event,${value.requestId},2)">Deny</button>
                                      </div>
                                  </td>
                              </tr>
                              </c:forEach>
                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
      </div>
      <div class="row">
          <div class="col-lg-12">
              <div class="box">
                  <div class="box-header with-border">
                      <h3 class="box-title">Request History</h3>
                  </div>
                  <div class="box-body">
                      <table id="process_requests_table" class="table table-striped table-bordered" style="width:100%">
                          <thead>
                              <tr>
                                  <td>Name</td>
                                  <td>Offer</td>
                                  <td>Action</td>
                              </tr>
                          </thead>
                          <tbody>
                              <c:forEach items="${requests}" var="value">
                              <tr>
                                  <td>
                                      <div class="row">
                                      <div class="col-xs-2">
	                                      <img src="/images/users/${value.tblMpUser.profilePic}" class="img-circle center-block img-responsive" style="height:40px; width:40px;">
	                                  </div>
	                                  <div class="col-xs-10">
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
                                      <div class="row">
                                      <div class="col-xs-2">
	                                      <img src="/images/offers/${value.tblMpRedeemOffers.offerImage}" class="img-circle center-block img-responsive" style="height:40px; width:40px;">
	                                  </div>
	                                  <div class="col-xs-10">
	                                      <b>${value.tblMpRedeemOffers.offerName}</b><br>
	                                      ${value.tblMpRedeemOffers.offerDescription}<br><br>
	                                      <b>Points : </b>${value.tblMpRedeemOffers.offerPoint}
	                                  </div>
                                      </div>
                                  </td>
                                  <td>
                                      ${value.requestStatus == 1 ? 'Accepted' : 'Denied'}
                                  </td>
                              </tr>
                              </c:forEach>
                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>


<script type="text/javascript" src="/js/custom/redeem.js"></script>

<jsp:include page='footer.jsp' />
