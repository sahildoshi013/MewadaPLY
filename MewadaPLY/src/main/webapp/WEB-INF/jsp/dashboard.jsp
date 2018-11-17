<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  <!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
        Dashboard
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-grey">
                    <div class="inner">
                        <h3>${user_count}</h3>

                        <p>Users</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-person"></i>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-grey">
                    <div class="inner">
                        <h3>${redeem_count}</h3>

                        <p>Redeem Requests</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-ribbon-b"></i>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-grey">
                    <div class="inner">
                        <h3>${point_count}</h3>

                        <p>Points Rewarded</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-cash"></i>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-grey">
                    <div class="inner">
                        <h3>${redeem_point_count}</h3>

                        <p>Redeem Points</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-code-download"></i>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
            <!-- Left col -->
            <section class="col-lg-6">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">Reward Points</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal" method="post" id="reward_form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="reward_point_phone" class="col-sm-4 control-label">Name/Phone No.</label>
                                <div class="col-sm-8">
                                    <select class="js-example-data-ajax form-control" name="user_id" style="width: 100%;" required></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="reward_point_points" class="col-sm-4 control-label">Points</label>
                                <div class="col-sm-8">
                                    <input type="number" class="form-control" required="required" id="reward_point_phone" placeholder="Points" required name="point">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="reward_point_comments">Comments</label>
                                <div class=" col-sm-8">
                                    <textarea class="form-control" rows="4" id="reward_point_comments" placeholder="Enter comments for rewards...(optional)" name="description" required></textarea>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" class="btn btn-info pull-right" id="reward_point_submit" onclick="add_reward(event)">Submit</button>
                        </div>
                        <!-- /.box-footer -->
                    </form>
                </div>
            </section>
            <!-- /.Left col -->
            <section class="col-lg-6">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">Point History</h3>
                    </div>
                    <div class="box-body">
                        <div class="row text-center">
                            <div class="col-md-9">
                            </div>
                            <div class="col-md-3">
                                Points
                                <hr>
                            </div>
                        </div>
                        <c:forEach items="${history}" var="value">
                        <div class="row">
                            <div class="col-sm-2">
                                <img src="images/users/${value.profile_pic}" class="img-circle center-block img-responsive" style="height:40px; width:40px;">
                            </div>
                            <div class="col-sm-7  text-center">
                                <b>${value.first_name} ${value.last_name}</b><br>
                                ${value.phone_no}
                            </div>
                            <div class="col-sm-3  text-center">
                            	${value.tran_type == 1  ? "+ " : "- "} ${value.tran_point}
                            </div>
                        </div>
                        <hr>
                        </c:forEach>
                        <button type="button" name="button" class="btn btn-info pull-right">See All</button>
                    </div>
                </div>
            </section>
        </div>
        <!-- /.row (main row) -->
    </section>
    <!-- /.content -->
</div>

<script type="text/javascript" src="/js/admin/users.js"></script>
<script type="text/javascript" src="/js/custom/dashboard.js"></script>

<jsp:include page='footer.jsp' />
