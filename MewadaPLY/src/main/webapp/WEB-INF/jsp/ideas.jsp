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
  
  <style type="text/css">
  .round-border {
      border-radius: 10px !important;
  }

  .box-image {
      position: relative;

  }

  .delete-image {
      position: absolute;
      top: 10px;
      right: 10px;
      display: none;
      color: #000000a6;
      font-size: 20px;
      cursor: pointer;
      box-shadow: 2px 2px 10px 1px;
      background-color: #ffffff26;
      padding: 3px;
      border-radius: 15px;
  }

  .box-image:hover .delete-image {
      display: block;
  }
  
  .fab{
	  	background: #367fa9;
		width: 50px;
		height: 50px;
		border-radius: 50%;
		text-align:center;
		color: #FFF;
		position: fixed;
		bottom: 70px;
		right: 50px;
		font-size: 2.6667em;
		display: inline-block;
		cursor: pointer;
  }
</style>

<!-- Dropzone -->
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">



  <jsp:include page='header.jsp'>
  	<jsp:param name="page" value="${page}"/>
  </jsp:include>
  <script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>
  
  <div class="content-wrapper">
  <section class="content-header">
      <h1 class="col-xs-12 col-sm-6 col-md-3">
        Trending Designs
    </h1>
      <div class="col-xs-12 col-sm-6 col-md-3 dropdown">
          <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${type.typeName}
            <span class="caret"></span>
        </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
          <c:forEach items="${types}" var="value">
          	<li><a href="${value.typeId}">${value.typeName}</a></li>
	      </c:forEach>
              <!--<li role="separator" class="divider"></li>
              <li><a href="#" data-toggle="modal" data-target="#add_category_dialog_box">Add New Category</a></li>-->
          </ul>
      </div>
  </section>

  <div class="clearfix"></div>

  <c:set var="total" value="${fn:length(ideas)}" />
  
  <section class="content">
      <!-- Split button -->
      <div class="row">
          <div class="col-sm-6 col-md-3">
      		  <c:forEach var="i" begin="0" end="${total-1}" step="4">  
	      		<div class="box-image">
		            <img class="img-responsive thumbnail" src="/images/designs/${ideas[i].designImage}" alt="${type.typeName} No ${ideas[i].designId}" style="width:100%;">
		            <i class="delete-image fa fa-trash" aria-hidden="true" onclick="delete_image(${ideas[i].designId})" id="${ideas[i].designId}"></i>
		        </div>
	          </c:forEach>  
          </div>
          <div class="col-sm-6 col-md-3">
          <c:forEach var="i" begin="1" end="${total-1}" step="4">  
    		<div class="box-image">
	            <img class="img-responsive thumbnail" src="/images/designs/${ideas[i].designImage}" alt="${type.typeName} No ${ideas[i].designId}" style="width:100%;">
	            <i class="delete-image fa fa-trash" aria-hidden="true" onclick="delete_image(${ideas[i].designId})" id="${ideas[i].designId}"></i>
	        </div>
        </c:forEach>
          </div>
          <div class="col-sm-6 col-md-3">
          <c:forEach var="i" begin="2" end="${total-1}" step="4">  
    		<div class="box-image">
	            <img class="img-responsive thumbnail" src="/images/designs/${ideas[i].designImage}" alt="${type.typeName} No ${ideas[i].designId}" style="width:100%;">
	            <i class="delete-image fa fa-trash" aria-hidden="true" onclick="delete_image(${ideas[i].designId})" id="${ideas[i].designId}"></i>
	        </div>
        </c:forEach>
          </div>
          <div class="col-sm-6 col-md-3">
          <c:forEach var="i" begin="3" end="${total-1}" step="4">  
    		<div class="box-image">
	            <img class="img-responsive thumbnail" src="/images/designs/${ideas[i].designImage}" alt="${type.typeName} No ${ideas[i].designId}" style="width:100%;">
	            <i class="delete-image fa fa-trash" aria-hidden="true" onclick="delete_image(${ideas[i].designId})" id="${ideas[i].designId}"></i>
	        </div>
        </c:forEach>
          </div>
      </div>
  </section>
</div>
<div class="fab" id="masterfab" onclick="add_image()"><span>+</span></div>
<!-- Add New Category-->
<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="add_category_dialog_box">
  <div class="modal-dialog modal-sm">
      <div class="modal-content round-border">
          <div class="modal-header">
              <h1 class="modal-title" id="exampleModalLabel" style="display: inline-block;">New Category</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <form method="post" id="category_form">
                <div class="form-group">
                  <label for="recipient-name" class="col-form-label">Category Name:</label>
                  <input type="text" class="form-control round-border" id="category_name" name="category_name" placeholder="Enter Category Name" required>
                </div>
              </form>
          </div>
          <div class="modal-footer">
              <button type="button" id="modal_close" class="btn btn-secondary round-border" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary round-border" onclick="addCategory()">Add Category</button>
          </div>
      </div>
  </div>
</div>
<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="add_image_model">
  <div class="modal-dialog">
      <div class="modal-content round-border">
          <div class="modal-header">
              <h3 class="modal-title" id="exampleModalLabel" style="display: inline-block;">Add New ${type.typeName}</h3>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <form action="/admin/ideas" class="dropzone round-border" id="my-awesome-dropzone" method="post" enctype="multipart/form-data">
                  <input type="hidden" name="type_id" value="${type.typeId}">
              </form>
          </div>
          <div class="modal-footer">
              <button type="button" id="modal_close" class="btn btn-secondary round-border" data-dismiss="modal">Close</button>
              <!-- <button type="button" class="btn btn-primary round-border" onclick="addCategory()">Add Category</button> -->
          </div>
      </div>
  </div>
</div>

<script type="text/javascript" src="/js/custom/ideas.js"></script>

<jsp:include page='footer.jsp' />
