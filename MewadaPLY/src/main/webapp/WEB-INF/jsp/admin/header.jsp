<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Mewada Ply | Admin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- DataTables -->
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap.min.css">

  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="css/bootstrap.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="css/admin/AdminLTE.min.css">
  <link rel="stylesheet" href="css/admin/style.css">

  <link rel="stylesheet" href="css/admin/mycss.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <!-- <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css"> -->

  <link rel="stylesheet" href="css/admin/skin-black.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="css/admin/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="css/admin/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="css/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="css/admin/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="css/admin/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="css/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- Scripts -->

  <!-- jQuery 2.2.3 -->
  <script src="css/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
  <!-- jQuery UI 1.11.4 -->
  <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
  <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
  <script>
    $.widget.bridge('uibutton', $.ui.button);
  </script>
  <!-- Bootstrap 3.3.6 -->
  <script src="js/bootstrap-3.1.1.min.js"></script>
  <!-- Morris.js charts -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
  <script src="css/admin/plugins/morris/morris.min.js"></script>
  <!-- Sparkline -->
  <script src="css/admin/plugins/sparkline/jquery.sparkline.min.js"></script>
  <!-- jvectormap -->
  <script src="css/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
  <script src="css/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
  <!-- jQuery Knob Chart -->
  <script src="css/admin/plugins/knob/jquery.knob.js"></script>
  <!-- daterangepicker -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
  <script src="css/admin/plugins/daterangepicker/daterangepicker.js"></script>
  <!-- datepicker -->
  <script src="css/admin/plugins/datepicker/bootstrap-datepicker.js"></script>
  <!-- Bootstrap WYSIHTML5 -->
  <script src="css/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
  <!-- Slimscroll -->
  <script src="css/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <!-- FastClick -->
  <script src="css/admin/plugins/fastclick/fastclick.js"></script>
  <!-- AdminLTE App -->
  <script src="js/admin/app.min.js"></script>
  <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
  <script src="js/admin/dashboard.js"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="js/admin/demo.js"></script>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style media="screen">
    .form-control{
        border-radius: 5px;
    }
    pre{
        white-space: normal;
    }
  </style>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="mewadaply395004admin/main/dashboard" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>MI</b>Ply</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Mewada</b>PLY</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">

          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="images/1.png" class="user-image" alt="User Image">
              <span class="hidden-xs">Mewada Prakash</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="images/1.png" class="img-circle" alt="User Image">

                <p>
                  Mewada Prakash
                  <small>Katargam, Surat.</small>
                </p>
              </li>
              <!-- Menu Body -->

              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-right">
                  <a href="mewadaply395004admin/home/signout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>

        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="images/1.png" style="height: auto;" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Mewada Prakash</p>
          <a><i class="fa fa-circle" style="color:#ffa700;"></i> Online</a>
        </div>
      </div>

      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
		
		<c:choose>
			<c:when test = "${page == 1}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/main/dashboard">
            <i class="fa fa-dashboard"></i>
            <span>Dashboard</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 2}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/redeem">
            <i class="fa fa-trophy"></i>
            <span>Redeem Requests</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 3}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/offer">
            <i class="fa fa-dollar"></i>
            <span>Reward Offers</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 4}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/design/design_trends/1">
            <i class="fa fa-fire"></i>
            <span>Design Trends</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 5}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/notification">
            <i class="fa fa-bell"></i>
            <span>Notification</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 6}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/main/points_history">
            <i class="fa fa-history"></i>
            <span>Points History</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 7}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/main/feedback">
            <i class="fa fa-comments"></i>
            <span>Feedbacks</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 8}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/main/user_data">
            <i class="fa fa-users"></i>
            <span>User Data</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 9}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/sites/">
            <i class="fa fa-building"></i>
            <span>Sites</span>
          </a>
        </li>

        <c:choose>
			<c:when test = "${page == 10}">
				<li class="active">
			</c:when>
			<c:otherwise>
				<li>
			</c:otherwise>
		</c:choose>
          <a href="mewadaply395004admin/sites/persons">
            <i class="fa fa-male"></i>
            <span>Architect/Mistry</span>
          </a>
        </li>

      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>