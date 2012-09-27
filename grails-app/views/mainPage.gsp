<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎来到Fire System</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
%{--<g:render template="/layouts/login" />--}%


<div class="wrapper">
    <div class="header">
        <div id="start"><img src="images/MSWINDOWS7.A.png" width="64"/></div><h1>欢迎来到Fire System</h1>
    </div>

    <div id="startMenu">
        <ul>
            <li ><a href="${createLink(uri: '/')}" style="color:#FFFFFF;float: left"><img src="${createLink(uri: '/')}images/HOME.png"  />主页</a></li>
            <li ><g:link controller="organization" action="list" style="color:#FFFFFF;float: left"><img src="${createLink(uri: '/')}images/TASKS_A.png"  />单位</g:link></li>
            <li ><g:link controller="building" action="list" style="color:#FFFFFF;float: left"><img src="${createLink(uri: '/')}images/TASKS_A.png"  />建筑</g:link></li>
        </ul>
    </div>

    <div class="container">
        <!--***************
          <div class="toolset">
              <img  class="tool" src="images/search.jpg">
              <img  class="tool" src="images/order.jpg">
              <img  class="tool" src="images/news.jpg">
              <img  class="tool" src="images/ask.jpg">
          </div>
          ****-->
        <div class="boxgridSet">
            <!--****************slidedown****************-->
            <div class="box slidedown">

                <div class="search" style="display:none">
                    <g:form url='[controller: "organization", action: "search"]'  id="searchableForm"  name="searchableForm"  method="get">
                        <label>输入</label>  <g:textField name="q" value="${params.q}" />
                    </g:form>
                </div>
                <div class="boxgrid "  onclick="searchableForm.submit()" >
                    <h3 > 查询</h3>
                    <div class="content">
                        <p><g:link controller="organization" action="list"  style="color:#FFFFFF;">单位信息</g:link></p>
                        <img src="images/map.jpg" width="300px" height="200px"/>
                    </div>
                </div>

            </div>
            <!--**************** slideright****************-->
            <div class="box slideleft">

                <div  class="news" style="display:none;" >
                    <h3><g:link controller="city" action="list">城市</g:link></h3>
                    <h3><g:link controller="district" action="list">区域</g:link></h3>
                </div>
                <div class="boxgrid" style="background:#B0EB17;position:absolute;margin-top:0;">
                    <h3>行政区域管理</h3>
                    <div class="content" style="background:#B0EB17">
                        <p></p>
                        <img src="images/pointer.png" style="margin:50px 160px " />
                    </div>
                </div>

            </div>

            <div class="box right" >
                <div class="boxrightgrid">
                <g:link controller="builderStructure" action="list"><h3>建筑结构</h3></g:link>
                <g:link controller="buildingOwnerType" action="list"><h3>建筑产权情况</h3></g:link>
                <g:link controller="buildingStatus" action="list"><h3>建筑情况</h3></g:link>
                <g:link controller="buildingType" action="list"><h3>建筑分类</h3></g:link>
                <g:link controller="fireFightingFacilities" action="list"><h3>消防设施</h3></g:link>
                <g:link controller="fireFightingFacilitiesStatus" action="list"><h3>消防设施状态</h3></g:link>
                <g:link controller="fireRating" action="list"><h3>消防等级</h3></g:link>


                    %{--<shiro:hasRole name="Administrator"><g:link controller="shiroRole" action="list"><h3>角色管理</h3></g:link>--}%
                        %{--<g:link controller="shiroUser" action="list"><h3>用户管理</h3></g:link>            </shiro:hasRole>--}%

                </div>

                <img id="target"  style="vertical-align: bottom;" src="images/FILE-MOVIE.png" />
                <img id="coffee" src="images/INTERNETEXPLORER-ALT.png" />
            </div>

            <!--**************** thecombo****************-->
            <div class="box slideright">
                <div  class="news2" style="display:none">
                    <h3> <g:link controller="organizationOtherType" action="list">单位情况</g:link> </h3>
                    <h3> <g:link controller="organizationType" action="list">单位类型</g:link>  </h3>
                </div>
                <div class="boxgrid" style="background:#39AB3E;position:absolute;margin-top:0;">

                    <h3>单位属性管理</h3>
                    <div class="content" style="background:#39AB3E">
                        <p></p>
                        <!--img id="me" src="images/pointer.gif" /-->
                        <img src="images/SETTINGS.png" style="margin:50px 160px;" />
                    </div>
                </div>
            </div>
            <!--**************** peek****************-->
            <div class="box">
                <div class="boxgrid peek" style="background:#8F2145">
                    <g:link controller="building" action="list"><h3 style="color:#FFFFFF;" > 建筑管理  </h3></g:link>
                    <a href="#"><img class="cover" src="images/PLAYER.png" style="margin:50px 150px;"/></a>
                </div>
            </div>

        </div>

        <div class="clear"></div>
    </div>


    <div class="footer"></div>

</div>
</body>


<script type="text/javascript" src="${createLink(uri: '/')}js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="${createLink(uri: '/')}js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${createLink(uri: '/')}js/script.js">	</script>
</html>
