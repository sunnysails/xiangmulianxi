<%--
  Created by IntelliJ IDEA.
  User: sunny
  Date: 2017/1/18
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>设备租赁新增</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../../include/css.jsp" %>
    <link rel="stylesheet" href="/static/css/bootstrap-datepicker.min.css">
    <!-- 文件上传 -->
    <link rel="stylesheet" href="/static/js/uploader/webuploader.css">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp" %>
    <%@include file="../../include/sider.jsp" %>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 业务</a></li>
                <li><a href="#">设备租赁</a></li>
                <li class="active">新增流水</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="box box-solid box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">新增租赁流水</h3>
                </div>
                <div class="box-body">
                    <form role="form" action="" onkeydown="if(event.keyCode==13){return false;}" method="post">
                        <%--公司 Lease--%>
                        <div class="box">
                            <div class="box-header with-border">
                                <h3 class="box-title">新租赁公司信息</h3>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label>租赁公司：&nbsp;</label>
                                    <input type="text" name="leaseCompany" id="lease_company">
                                </div>

                                <div class="form-group col-md-4">
                                    <label>地 &nbsp;&nbsp;址：&nbsp;</label>
                                    <input type="text" name="leaseAddress" id="lease_address">
                                </div>

                                <div class="form-group col-md-4">
                                    <label>公司电话：&nbsp;</label>
                                    <input type="text" name="leaseCompanyPhone" id="lease_company_phone">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label>法人代表：&nbsp;</label>
                                    <input type="text" name="leaseLegal" id="lease_legal">
                                </div>
                                <div class="form-group col-md-4">
                                    <label>电 &nbsp;&nbsp;话：&nbsp;</label>
                                    <input type="text" name="leaseLegalPhone" id="lease_legal_phone">
                                </div>

                                <div class="form-group col-md-4">
                                    <label>身份证号：&nbsp;</label>
                                    <input type="text" name="leaseLegalIdCard" id="lease_legal_id_card">
                                </div>
                            </div>
                            <!--金额 -->
                            <div class="row">

                                <div class="form-group col-md-4">
                                    <label>租金金额：</label>
                                    <input type="text" disabled="disabled" name="leaseAmount" id="amount">
                                </div>

                                <div class="form-group col-md-4">
                                    <label>预付款：&nbsp;</label>
                                    <input type="text" disabled="disabled" name="leasePrepaid" id="prepaid">
                                </div>

                                <div class="form-group col-md-4">
                                    <label>尾&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款：&nbsp;</label>
                                    <input type="text" disabled="disabled" name="leaseUnpaid" id="unpaid">
                                </div>
                            </div>
                        </div>
                        <%--公司结束--%>

                        <%--新设备--%>
                        <div id="add">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h3 class="box-title">新租赁设备</h3>
                                    <div class="box-tools pull-right">
                                        <a href="javascript:;" id="addDevice" class="btn"><i class="fa fa-plus"></i></a>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-md-4">
                                        <label>设备名称：&nbsp;</label>
                                        <select class="deviceId" name="deviceIds" style="height:29px;width:174px">
                                            <c:forEach items="${deviceList}" var="device">
                                                <option value="${device.id}"
                                                        rel="${device.id}">${device.deviceName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label>单 &nbsp;&nbsp;位：&nbsp;</label>
                                        <input class="Unit" type="text" name="deviceUnit">
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label>租赁单价：&nbsp;</label>
                                        <input class="UnitPrice" type="text" disabled="disabled"
                                               name="deviceUnitPrice">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-4">
                                        <label>归还时间：&nbsp;</label>
                                        <input class="backtime" id="back" type="text" name="backs">
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label>数&nbsp;&nbsp;量：&nbsp;</label>
                                        <input type="text" name="leaseNums">
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label>天&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：&nbsp;</label>
                                        <input class="disabled" type="text" disabled="disabled" name="leaseNum"
                                               placeholder="根据归还时间自动生成">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--设备结束--%>
                        <div>
                            <br/>
                        </div>
                        <div class="box" style="padding-left: 20px">
                            <div class="box-header">
                                <span class="title"><i class="fa fa-user"></i> 合同上传</span>
                            </div>
                            <%--<form action="" class="form-horizontal">--%>
                            <hr>
                            <p style="padding-left: 20px">注意事项</p>
                            <ul>
                                <li>上传合同扫描件要求清晰可见</li>
                                <li>合同必须公司法人签字盖章</li>
                            </ul>
                            <div class="form-actions">
                                <div id="picker">上传合同</div>
                            </div>
                            <%--</form>--%>
                        </div>
                        <div class="row">
                            <div class="col-md-3">

                            </div>

                            <div class="col-md-3 box-footer">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>

                            <div class="col-md-3 box-footer">
                                <button type="submit" class="btn btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                    <%--</form>--%>
                </div>
                <!-- /.box-body-->
            </div>
            <!-- /.box -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <%@ include file="../../include/footer.jsp" %>
</div>
<!-- ./wrapper -->
<%@ include file="../../include/js.jsp" %>
<%@ include file="../../include/moment.jsp" %>
<!-- datepicker -->
<script src="/static/js/bootstrap-datepicker.min.js"></script>
<script src="/static/js/bootstrap-datepicker.zh-CN.min.js"></script>
<script src="/static/js/uploader/webuploader.min.js"></script>
<script>
    $(function () {
        $("#back").datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            //clearBtn: true,//清除按钮
            //todayBtn: true,//今日按钮
            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
        });

        $("#addDevice").click(function () {
            var $html = $(this).parent().parent().parent();
            $("#add").append($html.clone(true));
        });

        $(".deviceId").mouseleave(function () {
            var deviceId = $(this).val();
            <c:forEach items="${deviceList}" var="device">
            if (${device.id} == deviceId
            )
            {
                $(this).parent().parent().parent().find(".Unit").val("${device.deviceUnit}");
                $(this).parent().parent().parent().find(".UnitPrice").val("${device.deviceUnitPrice}");
            }
            </c:forEach>
        });
        $(".backtime").mouseleave(function () {
            var day = $(this).val();
            var now = moment().format("YYYY-MM-DD");
            var a = DateDiff(day, now);
            if (a > 0){
                $(".disabled").val(a);
            }else {
                $(".disabled").val("日期错误");
                a=0;
            };
            $(".backtime").val(day);

            var b = $(".UnitPrice").valueOf();
            console.log(b);
        });

        function DateDiff(sDate1, sDate2) {    //sDate1和sDate2是2006-12-18格式
            var aDate, oDate1, oDate2, iDays
            aDate = sDate1.split("-")
            oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])    //转换为12-18-2006格式
            aDate = sDate2.split("-")
            oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])
            iDays = parseInt((oDate1 - oDate2) / 1000 / 60 / 60 / 24)    //把相差的毫秒数转换为天数
            return iDays
        }

        //文件上传
        var uploder = WebUploader.create({
            swf: "js/uploader/Uploader.swf",
            server: "#",
            pick: '#picker',
            auto: true,
            fileVal: 'file',
            /*accept: {
             title: 'Images',
             extensions: 'gif,jpg,jpeg,bmp,png',
             mimeTypes: 'image/!*'
             }*/
        });
    });
</script>
</body>
</html>