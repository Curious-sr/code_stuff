<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Batch Project</title>

        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
        <script
            src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <script
            src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
        <link rel="stylesheet"
            href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>
    <body>

        <form action="./save" method="post" enctype="multipart/form-data"
            onsubmit="return validate()">

            <div class="row">
                <div class="col-sm-4">
                  
                    <label class="text-primary">Select
                        Batch:<sup>*</sup></label>
                    <select onchange="subscription()" id="batch_id"
                        name="batch_id" class="form-control">
                        <option value="0">--Select--</option>
                        <c:forEach var="batch" items="${AllBatch}">
                            <option value="${batch.batch_id}">${batch.batch_Name}</option>
                
                        </c:forEach>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label class="text-primary">Select
                        Technology:<sup>*</sup></label>
                    <select id="technologyId" name="technologyId"
                        class="form-control">
                        <option value="0">--Select--</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label class="text-primary"><sup>*</sup> Mandatory
                        Field</label>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <label class="text-primary">Name:<sup>*</sup></label>
                    <input type="text" name="applicantName" id="applicantName"
                        class="form-control">
                </div>
                <div class="col-sm-4">
                    <label class="text-primary">Email:<sup>*</sup></label>
                    <input type="text" name="emailId" id="emailId"
                        class="form-control">
                </div>
                <div class="col-sm-4">
                    <label class="text-primary">Mobile No:<sup>*</sup></label>
                    <input type="text" name="mobileNo" id="mobileNo"
                        class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <label class="text-primary">Date of Birth</label>
                    <input type="text" name="dob" id="dob" class="form-control">
                </div>
                <div class="col-sm-4">
                    <label class="text-primary">Gender</label>
                    <input type="radio" value="Male" id="gender"
                        name="gender">Male
                    <input type="radio" value="Female" id="gender"
                        name="gender">Female
                </div>
                <div class="col-sm-4">
                    <label class="text-primary">Upload
                        Photo<sup>*</sup>:</label>
                    <input type="file" name="imagePath" id="imagePath"
                        class="form-control">
                </div>
            </div>
            <div align="center">
                <input type="submit" value="Submit" class="btn btn-success">
                <input type="reset" value="Reset" class="btn btn-warning">
            </div>
        </form>

    </body>

    











    <script type="text/javascript">
    function subscription(){
        var batch=$("#batch_id").val();
        $.ajax({
            type:"GET",
            url:"./getSubscriptionBybatch_id",
            data:"batchId="+batch,
            success:function(response){
              console.log("success...");
                }
    
            });
        }
    $(function() {
        $("#dob").datepicker();
        });
    </script>

    <script type="text/javascript">
        function validate() {
            var name = document.getElementById('applicantName').value;
            if (name.length <= 3) {
                alert("Name length must be greater than 3")
                return false;
            }
            for(var i=0;i<name.length;i++){
                if(!((name[i]>='A' && name[i]<='Z')||(name[i]>='a' && name[i]<='z')||name[i]==" ")){
                    alert("Name must be character only not number");
                    return false;
                    }
                }
            var mailformat = /^[a-z0-9]{3,}@[a-z]{3,}[.]{1}[a-z.]{2,6}$/;
            var email=document.getElementById('emailId').value;
            if(email.length<=0){
                alert("Please Enter Email Id")
                return false;
            }
            if(!(mailformat.test(email))){
                alert("Please provide valid email")
                return false;
                }
            var mobile=document.getElementById('mobileNo').value;
            if(mobile.length<=0){
                alert("Please Enter Email Id")
            }
            if (mobile.length <10 || mobile.length>10) {
                alert("Mobile length must be 10 digit")
                return false;
            }
            
            return true;
        }
        
    </script> 
</html>
