<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27-Aug-21
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>

    <title>Spring Boot</title>

    <script src="/resources/jquery/jquery.min.js"></script>

    <script src="/resources/jquery-validation/jquery.validate.js"></script>

    <style>
        .error{
            color: red;
        }
    </style>

    <script>

        $(document).ready(function () {
            jQuery.validator.addMethod("noSpace", function(value, element) {
                return value == '' || value.trim().length != 0;
            },
                "No space please and don't leave it empty");
            jQuery.validator.addMethod("EId", function(value, element) {
                return this.optional( element ) || /^(E)[0-9]{1,3}$/.test( value );
            },
                "Please enter valid ID!");
            jQuery.validator.addMethod("EName", function(value, element) {
                return this.optional( element ) || /^[A-z ]{1,}$/.test( value );
            },
                "Please enter valid Name!");
            jQuery.validator.addMethod("EContact", function(value, element) {
                return this.optional( element ) ||/^[0-9]{10,11}$/.test( value );
            },
                "Please enter valid Contact!");
            jQuery.validator.addMethod("EAddress", function(value, element) {
                return this.optional( element ) || /^[A-z ]{1,}$/.test( value );
            },
                "Please enter valid Address!");

            $('#employeeRegister').validate({
                rules:{

                    empid: {
                        required: true,
                        EId: true,
                        // noSpace:true
                    },
                    //username is the name of the textbox
                    empname: {
                        required: true,
                        //alphanumeric is the custom method, we defined in the above
                        EName: true
                    },
                    empcontact: {
                        required: true,
                        EContact: true,
                        // noSpace:true
                    },
                    empaddress: {
                        required: true,
                        EAddress: true
                    },

                },
                messages:{
                    empid: {
                        //error message for the required field
                        required: 'Please enter id!',
                        noSpace: 'Please do not put space!',
                        EId: 'Please enter valid ID.(Ex:E001)'
                    },
                    empname: {
                        required: 'Please enter name!',
                        EName:'Please enter Valid Name.(Ex:Nimal Perera)'
                    },
                    empcontact: {
                        required: 'Please enter Contact!',
                        EContact:'Only five 10 or 11 numbers you can use.(Ex:0128569875)'
                    },
                    empaddress: {
                        required: 'Please enter Address!',
                        EAddress:'Please enter Valid Address(Ex:Galle)'
                    },
                },

            })

        })
    </script>
</head>
<body>

<div class="container-fluid mt-5" >
    <div class="row mt-1 p-0">
        <div class="col-xl-4">
            <div class="bg-white card">
                <div class="card-header text-white" style="font-size: 50px; position: absolute; left: 675px;">
                    Employee Form
                </div>
                <form action="" id="employeeRegister">
                <div class="card-body" style="position: absolute; left: 675px; top: 150px; font-size: 25px" >
                    <div class="row p-2 mt-1">
                        <div class="form-group col-12">
                            <lable>Employee ID</lable>
                            <input type="text" id="id" name="empid" class="form-control">
                        </div>
                    </div>
                    <div class="row p-2 mt-0">
                        <div class="form-group col-12">
                            <lable>Employee Name</lable>
                            <input type="text" id="name" name="empname" class="form-control" >
                        </div>
                    </div>
                    <div class="row p-2 mt-0">
                        <div class="form-group col-12">
                            <lable>Employee Contact</lable>
                            <input type="text" id="contact" name="empcontact" class="form-control" >
                        </div>
                    </div>
                    <div class="row p-2 mt-0">
                        <div class="form-group col-12">
                            <lable>Employee Address</lable>
                            <input type="text" id="address" name="empaddress" class="form-control" >
                        </div>
                    </div>
                    <div class="row p-1 mt-5" align="right">
                        <div class="form-group col-12" style="position: absolute; top: 150px;">
                            <button type="button" class="btn  text-white fw-bold"style="background-color: #0652DD ; font-size: 20px" id="btnUpdate">Update</button>
                            <button type="button" class="btn  text-white fw-bold"style="background-color: #EA2027 ; font-size: 20px" id="btnDelete">Delete</button>
                            <button type="button" class="btn  text-white fw-bold" style="background-color: #009432 ; font-size: 20px" id="btnSearch">Search</button>

                        </div>
                    </div>
                </div>
                </form>
                <button type="button" class="btn  text-white fw-bold" style="background-color: #009432 ; font-size: 20px" id="btnSave">Save</button>
            </div>
        </div>
    </div>
</div>

<script src="/resources/jquery/jquery.min.js"></script>

<script src="/resources/jquery-validation/jquery.validate.js"></script>

<script>

//Save

$("#btnSave").click(function (){

    if ($('#employeeRegister').valid()) {

        let id = $("#id").val();
        let name = $("#name").val();
        let contact = $("#contact").val();
        let address = $("#address").val();

        $.ajax({
            url: '/api/save',
            method: 'post',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify({
                id: id,
                name: name,
                contact: contact,
                address: address
            }),
            success: function (data) {
                console.log(data);
            }
        });
    }
    });


//Update
$("#btnUpdate").click(function (){

    if ($('#employeeRegister').valid()) {

        let id = $("#id").val();
        let name = $("#name").val();
        let contact = $("#contact").val();
        let address = $("#address").val();

        $.ajax({
            url: '/api/update',
            method: 'put',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify({
                id: id,
                name: name,
                contact: contact,
                address: address
            }),

            success: function (data) {
                console.log(data);

            }
        });
    }
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
})

 // $("#id").on('keyup', function (eObj) {
 //                        if (eObj.key == "Enter") {
 //                            let id=$("#id").val();
 //                            $.ajax({
 //                                url:'/api/search/'+id,
 //                                method:'GET',
 //                                async:true,
 //                                contentType:'application/json',
 //                                success:function (data){
 //                                    console.log(data);
 //                                    $("#txtName").val(data.name);
 //                                    $("#txtContact").val(data.contact);
 //                                    $("#txtAddress").val(data.address);
 //                                }
 //                            })
 //                        }
 //                    })






</script>



</body>
</html>
