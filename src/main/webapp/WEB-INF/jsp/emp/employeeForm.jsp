<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27-Aug-21
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Boot</title>
</head>
<body>

<div class="container-fluid mt-5" id="employeeForm">
    <div class="row mt-1 p-0">
        <div class="col-xl-4">
            <div class="bg-white card">
                <div class="card-header text-white" style="font-size: 50px; position: absolute; left: 675px;">
                    Employee Form
                </div>
                <div class="card-body" style="position: absolute; left: 675px; top: 150px; font-size: 25px" >
                    <div class="row p-2 mt-1">
                        <div class="form-group col-12">
                            <lable>Employee ID</lable>
                            <input type="text" id="id" class="form-control">
                        </div>
                    </div>
                    <div class="row p-2 mt-0">
                        <div class="form-group col-12">
                            <lable>Employee Name</lable>
                            <input type="text" id="name" class="form-control" >
                        </div>
                    </div>
                    <div class="row p-2 mt-0">
                        <div class="form-group col-12">
                            <lable>Employee Contact</lable>
                            <input type="text" id="contact" class="form-control" >
                        </div>
                    </div>
                    <div class="row p-2 mt-0">
                        <div class="form-group col-12">
                            <lable>Employee Address</lable>
                            <input type="text" id="address" class="form-control" >
                        </div>
                    </div>
                    <div class="row p-1 mt-5" align="right">
                        <div class="form-group col-12" style="position: absolute; top: 150px;">
                            <button type="button" class="btn  text-white fw-bold" style="background-color: #009432 ; font-size: 20px" id="btnSave">Save</button>
                            <button type="button" class="btn  text-white fw-bold"style="background-color: #0652DD ; font-size: 20px" id="btnUpdate">Update</button>
                            <button type="button" class="btn  text-white fw-bold"style="background-color: #EA2027 ; font-size: 20px" id="btnDelete">Delete</button>
                            <button type="button" class="btn  text-white fw-bold" style="background-color: #009432 ; font-size: 20px" id="btnSearch">Search</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xl-8 col-lg-6" style="position: absolute;color: black; left: 675px; top: 450px;background: white;font-size: 25px ">

            <table class="table table-hover border mt-1">
                <thead class="">
                <tr>
                    <th scope="col">Customer ID</th>
                    <th scope="col">Customer Name</th>
                    <th scope="col">Customer Contact</th>
                    <th scope="col">Customer Address</th>

                </tr>
                </thead>
                <tbody class="" style="background: white">
                <tr>
                    <th scope="row">1</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="/resources/jquery/jquery.min.js"></script>

<script>

//Save
    $("#btnSave").click(function (){

        let id = $("#id").val();
        let name = $("#name").val();
        let contact = $("#contact").val();
        let address = $("#address").val();

        $.ajax({
            url:'/api/save',
            method:'post',
            async:true,
            contentType:'application/json',
            data:JSON.stringify({
                id:id,
                name:name,
                contact:contact,
                address:address
            }),
            success:function (data){
                console.log(data);

            }
        });
    });

    //Update

    $("#btnUpdate").click(function (){
        let id = $("#id").val();
        let name = $("#name").val();
        let contact = $("#contact").val();
        let address = $("#address").val();


        $.ajax({
            url: '/api/update',
            method: 'put',
            async:true,
            contentType: 'application/json',
            data: JSON.stringify({
                id:id,
                name:name,
                contact:contact,
                address:address
            }),

            success:function (data){
                console.log(data);

            }
        });
    });

//Delete

$("#btnDelete").click(function () {
    let ID = $("#id").val();

    let option=confirm('Do You Want to Delete Employee ID ? :'+ID);
    if (option) {
        $.ajax({
            url: '/api/delete/${id}'+ID,
            method: 'delete',
            async: true,
            contentType: 'application/json',

            success: function (data) {
                console.log("deleted");
            }
        })
    }
})





// search
$("#btnSearch").click(function (){
    let id=$("#id").val();
    $.ajax({
        url:'/api/search/'+id,
        method:'GET',
        async:true,
        contentType:'application/json',
        success:function (data){
            console.log(data);
            $("#name").val(data.name);
            $("#contact").val(data.contact);
            $("#address").val(data.address);
        }
    })
});


$("#id").on('keyup', function (eObj) {
    if (eObj.key == "Enter") {
        let id=$("#id").val();
        $.ajax({
            url:'/api/search/${id}',
            method:'GET',
            async:true,
            contentType:'application/json',
            success:function (data){
                console.log(data);
                $("#txtName").val(data.name);
                $("#txtContact").val(data.contact);
                $("#txtAddress").val(data.address);
            }
        })
    }
})

</script>


</body>
</html>
