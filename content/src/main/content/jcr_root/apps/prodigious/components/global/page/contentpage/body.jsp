<%@include file="/apps/prodigious/components/global/global.jsp" %>
<body>
    <!--[if lt IE 7]>
        <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Project name</a>
	    </div>
	    <div class="navbar-collapse collapse">
	      <form class="navbar-form navbar-right" role="form">
	        <div class="form-group">
	          <input type="text" placeholder="Email" class="form-control">
	        </div>
	        <div class="form-group">
	          <input type="password" placeholder="Password" class="form-control">
	        </div>
	        <button type="submit" class="btn btn-success">Sign in</button>
	      </form>
	    </div><!--/.navbar-collapse -->
	  </div>
	</div>
	
	<cq:include path="hero" resourceType="prodigious/components/global/content/hero" />
	
	<div class="container">
	  <!-- Example row of columns -->
	  <div class="row">
	  	<cq:include script="content.jsp" />
	  </div>
	
	  <hr>
	
	  <footer>
	    <p>&copy; Company 2015</p>
	  </footer>
	</div> <!-- /container -->
</body>