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
</style>
  
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <section class="content-header">
      <h1>
          Redeem Offers
      </h1>
  </section>

  <div class="clearfix"></div>

  <section class="content">
  <c:set var="total" value="${fn:length(offers)}" />
      <div class="row">
          <div class="col-md-3 col-sm-6 col-xs-12">
              <!-- Offer Image -->
              <div class="box box-primary">
                  <div class="box-body box-profile">
                      <img class="profile-user-img img-responsive img-circle" src="/images/plus.svg" alt="button to add offers" onclick="add_offer()" style="margin: 65px auto;cursor:pointer;">
                  </div>
                  <!-- /.box-body -->
              </div>
              <!-- /.box -->
              <c:forEach var="i" begin="3" end="${total-1}" step="4">
                  <!-- Offer Image -->
                  <div class="box ${offers[i].offerActive ? 'box-primary' : 'box-default'}">
                      <div class="box-body box-profile thumbnail">
                          <img class="profile-user-img img-responsive img-circle" src="/images/offers/${offers[i].offerImage}" alt="offer image" style="height: 100px;">
                          <h3 class="profile-username text-center">${offers[i].offerName}</h3>
                          <div>
                              <span class="pull-right" style="padding: 1px 3px;">
                              	${offers[i].offerActive ? 'Active' : 'Deactive'}
                              </span>
                              <label class="switch pull-right">
                                  <input type="checkbox" onclick="toggleOffer(${offers[i].offerId})" ${offers[i].offerActive ? 'checked' : ''} ></input>
                                  <span class="slider round"></span>
                              </label>
                          </div>
                          <p class="text-muted text-center">Points - ${offers[i].offerPoint}</p>
                          <pre>${offers[i].offerDescription}</pre>
                          <div class="col-xs-6">
                            <button class="btn ${offers[i].offerActive ? 'btn-primary' : 'btn-default'}" onclick="edit_offer(${offers[i].offerId})"><b>Update</b></button>
                          </div>
                          <div class="col-xs-6">
                            <button href="#" class="btn btn-link" id="${offers[i].offerId}" onclick="delete_offer(${offers[i].offerId})"><b>Delete</b></button>
                          </div>
                      </div>
                      <!-- /.box-body -->
                  </div>
                  <!-- /.box -->
              </c:forEach>
          </div>
          <div class="col-md-3 col-sm-6 col-xs-12">
          <c:forEach var="i" begin="0" end="${total-1}" step="4">
          <!-- Offer Image -->
          <div class="box ${offers[i].offerActive ? 'box-primary' : 'box-default'}">
              <div class="box-body box-profile thumbnail">
                  <img class="profile-user-img img-responsive img-circle" src="/images/offers/${offers[i].offerImage}" alt="offer image" style="height: 100px;">
                  <h3 class="profile-username text-center">${offers[i].offerName}</h3>
                  <div>
                      <span class="pull-right" style="padding: 1px 3px;">
                      	${offers[i].offerActive ? 'Active' : 'Deactive'}
                      </span>
                      <label class="switch pull-right">
                          <input type="checkbox" onclick="toggleOffer(${offers[i].offerId})" ${offers[i].offerActive ? 'checked' : ''} ></input>
                          <span class="slider round"></span>
                      </label>
                  </div>
                  <p class="text-muted text-center">Points - ${offers[i].offerPoint}</p>
                  <pre>${offers[i].offerDescription}</pre>
                  <div class="col-xs-6">
                    <button class="btn ${offers[i].offerActive ? 'btn-primary' : 'btn-default'}" onclick="edit_offer(${offers[i].offerId})"><b>Update</b></button>
                  </div>
                  <div class="col-xs-6">
                    <button href="#" class="btn btn-link" id="${offers[i].offerId}" onclick="delete_offer(${offers[i].offerId})"><b>Delete</b></button>
                  </div>
              </div>
              <!-- /.box-body -->
          </div>
          <!-- /.box -->
      </c:forEach>
          </div>
          <div class="col-md-3 col-sm-6 col-xs-12">
          <c:forEach var="i" begin="1" end="${total-1}" step="4">
          <!-- Offer Image -->
          <div class="box ${offers[i].offerActive ? 'box-primary' : 'box-default'}">
              <div class="box-body box-profile thumbnail">
                  <img class="profile-user-img img-responsive img-circle" src="/images/offers/${offers[i].offerImage}" alt="offer image" style="height: 100px;">
                  <h3 class="profile-username text-center">${offers[i].offerName}</h3>
                  <div>
                      <span class="pull-right" style="padding: 1px 3px;">
                      	${offers[i].offerActive ? 'Active' : 'Deactive'}
                      </span>
                      <label class="switch pull-right">
                          <input type="checkbox" onclick="toggleOffer(${offers[i].offerId})" ${offers[i].offerActive ? 'checked' : ''} ></input>
                          <span class="slider round"></span>
                      </label>
                  </div>
                  <p class="text-muted text-center">Points - ${offers[i].offerPoint}</p>
                  <pre>${offers[i].offerDescription}</pre>
                  <div class="col-xs-6">
                    <button class="btn ${offers[i].offerActive ? 'btn-primary' : 'btn-default'}" onclick="edit_offer(${offers[i].offerId})"><b>Update</b></button>
                  </div>
                  <div class="col-xs-6">
                    <button href="#" class="btn btn-link" id="${offers[i].offerId}" onclick="delete_offer(${offers[i].offerId})"><b>Delete</b></button>
                  </div>
              </div>
              <!-- /.box-body -->
          </div>
          <!-- /.box -->
      </c:forEach>
          </div>
          <div class="col-md-3 col-sm-6 col-xs-12">
          <c:forEach var="i" begin="2" end="${total-1}" step="4">
          <!-- Offer Image -->
          <div class="box ${offers[i].offerActive ? 'box-primary' : 'box-default'}">
              <div class="box-body box-profile thumbnail">
                  <img class="profile-user-img img-responsive img-circle" src="/images/offers/${offers[i].offerImage}" alt="offer image" style="height: 100px;">
                  <h3 class="profile-username text-center">${offers[i].offerName}</h3>
                  <div>
                      <span class="pull-right" style="padding: 1px 3px;">
                      	${offers[i].offerActive ? 'Active' : 'Deactive'}
                      </span>
                      <label class="switch pull-right">
                          <input type="checkbox" onclick="toggleOffer(${offers[i].offerId})" ${offers[i].offerActive ? 'checked' : ''} ></input>
                          <span class="slider round"></span>
                      </label>
                  </div>
                  <p class="text-muted text-center">Points - ${offers[i].offerPoint}</p>
                  <pre>${offers[i].offerDescription}</pre>
                  <div class="col-xs-6">
                    <button class="btn ${offers[i].offerActive ? 'btn-primary' : 'btn-default'}" onclick="edit_offer(${offers[i].offerId})"><b>Update</b></button>
                  </div>
                  <div class="col-xs-6">
                    <button href="#" class="btn btn-link" id="${offers[i].offerId}" onclick="delete_offer(${offers[i].offerId})"><b>Delete</b></button>
                  </div>
              </div>
              <!-- /.box-body -->
          </div>
          <!-- /.box -->
      </c:forEach>
          </div>
      </div>
  </section>

  <div class="modal fade" id="modal-default">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title">Add Offer</h4>
        </div>
        <form enctype="multipart/form-data" accept-charset="utf-8" name="offer_form" id="offer_form"  method="post" action="">
            <div class="modal-body">
                  <div class="box-body">
                      <div class="form-group">
                          <label for="offer_name">Offer Name</label>
                          <input type="text" name="offer_name" placeholder="Enter Offer Name" class="form-control" required>
                      </div>
                      <div class="form-group">
                          <label for="offer_description">Offer Description</label>
                          <textarea name="offer_description" placeholder="Enter Description about Offer" class="form-control" required></textarea>
                      </div>
                      <div class="form-group">
                          <label for="offer_point">Offer Points</label>
                          <input type="number" name="offer_point" placeholder="Enter Offer Points" class="form-control" required>
                      </div>
                      <div class="form-group">
                          <label for="offer_image">Display Image</label>
                          <input type="file" id="offer_image" name="offer_image" class="form-control" accept="images/*" required>
                      </div>
                      <input type="hidden" name="offer_id">
                      <input type="hidden" name="offer_image_name">
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" name="submit" value="Save changes" onclick="save(event)">
                  </div>
            </div>
        </form>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
   <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript" src="/js/custom/offers.js"></script>

<jsp:include page='footer.jsp' />
