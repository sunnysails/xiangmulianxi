<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Left side column. contains tde sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-address-card"></i>
                    <span>账户管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/new"><i class="fa fa-circle-o"></i> 新增账户</a></li>
                    <li><a href="/user"><i class="fa fa-circle-o"></i> 账户列表</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>财务报表</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../charts/chartjs.html"><i class="fa fa-circle-o"></i> 日报</a></li>
                    <li><a href="../charts/morris.html"><i class="fa fa-circle-o"></i> 月报</a></li>
                    <li><a href="../charts/flot.html"><i class="fa fa-circle-o"></i> 年报</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>业务</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> 设备租赁<i class="fa fa-angle-left pull-right"></i></a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> 业务流水</a></li>
                            <li>
                                <a href="#"><i class="fa fa-plus"></i> 新增流水 </a>
                            </li>
                        </ul>
                    </li>

                    <li><a href="#"><i class="fa fa-circle-o"></i> 设备管理<i class="fa fa-angle-left pull-right"></i></a>
                        <ul class="treeview-menu">
                            <li><a href="/business/device"><i class="fa fa-circle-o"></i> 设备库存</a></li>
                            <li><a href="/business/device/new"><i class="fa fa-plus"></i> 新增设备 </a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-circle-o"></i> 劳务外包 <i class="fa fa-angle-left pull-right"></i></a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> 业务流水</a></li>
                            <li>
                                <a href="#"><i class="fa fa-plus"></i> 新增流水 <i class="fa fa-angle-left pull-right"></i></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i>
                    <span>公司网盘</span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>