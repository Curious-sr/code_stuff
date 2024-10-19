

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <title>Home Page| Batch Master Project</title>
    <style>
        .container {
            margin-left: 200px;
            background-color: cyan;
        }
        .reportcontainer{
            margin-left: 200px;
            background-color: rgb(53, 156, 156);
        }
        .addOrange{
            background-color: orange; color: white; border: 1px solid darkorange; padding: 0.375rem 0.75rem; border-radius: 0.25rem;
        }
        .boldData{
            font-weight: bold;
        }
        .content{
            margin-left: 200px;
            margin-right: 200px;

        }
        .reportcontent{
            margin-right: 200px;
        }
        fieldset {
            border: 2px solid #ccc;
            padding: 10px;
        }
        legend {
            font-weight: bold;
        }



        <!-- Table style -->
        .tableView {
            width: 100%;
            overflow-x: auto; /* Enables horizontal scrolling if needed */
            margin-left: 200px;

        }

        table {
            width: 100%;
            border-collapse: collapse; /* Removes gaps between borders */
        }

        th, td {
            border: 1px solid #ddd; /* Light grey border for cells */
            padding: 8px; /* Padding inside cells */
            text-align: left; /* Aligns text to the left */
        }

        th {
            background-color: #f4f4f4; /* Light grey background for header */
            font-weight: bold; /* Makes header text bold */
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Zebra striping for even rows */
        }

        tr:hover {
            background-color: #ddd; /* Light grey background on hover */
        }
    </style>
</head>
<body>
    <h1 class="text text-center">Batch Master Project</h1>
    <h2>${batches}</h2>
    <div class="container">
        <fieldset>
            <legend>Mark Entry Form</legend>
          
                <div class="content">
                     <div class="form-group">
                    <div class="row">
                        <div class="col-4">
                                <label for="batch" class="boldData">Select Batch:</label>
                        </div>
                        <div class="col-8">
                            <select id="batch"  class="form-control addOrange">
                                 <option>-select-</option>
                            </select>
                        </div>
                        
                               
                    </div>
                    
                </div>
                
                <br><br>
                <div class="form-group">
                    <div class="row">
                        <div class="col-4">
                            <label for="technology" class="boldData">Select Technology:</label>
                        </div>
                        <div class="col-8">
                            <select id="technology"  class="form-control addOrange">
                                 <option>-select-</option>
                            </select>
                        </div>
                    
                </div>
                
                <br><br>
                <div class="form-group">
                    <div class="row">
                        <div class="col-4">
                            <label for="employeeName" class="boldData">Select Employee Name:</label>
                        </div>
                    <div class="col-8">
                        <select id="employeeName"  class="form-control addOrange">
                            <option>-select-</option>
                        </select>
                    </div>
                </div>
                
                <br><br>
                <div class="form-group">
                    <div class="row">
                        <div class="col-4">
                                <label for="mark" class="boldData">Enter Mark:</label>
                        </div>
                        <div class="col-8">
                                <input type="text" id="mark" class="form-control addOrange" name="mark">
                        </div>
                    
                </div>
                
                <br><br>
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-8">
                        <button type="submit" id="submitBtn"  class="btn btn-primary boldData">Save</button>
                    </div>
                
                </div>
               
           
        </fieldset>
    </div>
    
    <br><br>
    <div class="container reportcontainer">
        <fieldset>
           
                <div class="reportcontent">
                     <div class="form-group">
                    <div class="row">
                        <div class="col-4">
                                <label for="batch" class="boldData">Select Batch:</label>
                        </div>
                        <div class="col-4">
                            <select id="batchSearch"  class="form-control addOrange">
                                 <option>-select-</option>
                            </select>
                        </div>
                        
                        <div class="col-4">
                            <button type="submit" id="showBtn" class="btn btn-primary boldData" onclick="showReport()">Show Report</button>
                        </div>
                               
                    </div>
                    
                </div>
                
                <br><br>
    
            <div id="tableView">
            </div>
            <br><br><br>
            <center><button   class="btn btn-primary boldData " onclick="pdfReport()">Download Pdf Format</button></center>
        </fieldset>
    </div>
               
    <script>
      
        $(document).ready(function() {
           initialize();
           initializegetEmployee();
           saveData();    
        });
        function pdfReport(){
            const userConfirmed = confirm("Do you want to download the report ?");
            if (userConfirmed) {
                console.log("User confirmed.");
                fetch('/pdfReport', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
                .then(response => {
                    if (response.ok) {
                        return response.blob(); 
                    }
                    throw new Error('Network response was not ok.');
                })
                .then(blob => {
                    
                    const url = window.URL.createObjectURL(blob);
                    
                    const a = document.createElement('a');
                    a.href = url;
                    a.download = 'Report.pdf'; 
                    document.body.appendChild(a);
                    a.click(); 
                    a.remove(); 
                })
                .catch(error => {
                    console.error('There was a problem with the fetch operation:', error);
                });
            } else {
                console.log("User canceled.");
            }
           
        }
        //for search
        function showReport(){

            let batchId = $('#batchSearch').val();
            if(batchId == "" ){
                alert("Select Batch");
                return false;
                }
            if(batchId > 0 ){
                fetchTableData(batchId);
            }

        }

        //for save
        function saveData(){
            $('#submitBtn').click(function() {
                let employee_id = $('#employeeName').val();
                let mark = $('#mark').val();
                if(employee_id > 0 && ( mark !="" || mark >0)){
                    saveAssessmentMark();
                }
            });
        }

        function initializegetEmployee(){
            $('#technology').click(function() {
                let batch_id = $('#batch').val();
                let technology_id = $('#technology').val();
                if(technology_id > 0 && batch_id >0){
                    getEmployee();
                }
            });
        }


        function saveAssessmentMark(){
            let employee_id = $('#employeeName').val();
            let mark = $('#mark').val();
           
            if(mark == "" ){
                    alert("Select employee");
                    return false;
            }
           

            var postData = {
                empid: employee_id,
                mark: mark,
            };

            
            $.ajax({
                url: './saveAssessment',
                method: 'POST',
                contentType: 'application/json', 
                data: JSON.stringify(postData),
                dataType: 'json',
                success: function(response) {
                    console.log(response); 
                    if(response.status ==200){
                        alert(response.message);
                    }
                    else{
                        alert(response.message);
                    }
                    
                },
                error: function(xhr, status, error) {
                    console.error("Error sending data:");
                }
            });
            fetchTableData();
        }



        function getEmployee(){
            let batch_id = $('#batch').val();
            let technology_id = $('#technology').val();
            if(batch_id ==0){
                    alert("Select batch");
                    return false;
            }
           

            var postData = {
                batch_id: batch_id,
                technology_id: technology_id,
            };

          
            $.ajax({
                url: './getEmployeeList', 
                method: 'POST',
                contentType: 'application/json', 
                data: JSON.stringify(postData), 
                dataType: 'json',
                success: function(response) {
                    console.log(response); 
                    $('#employeeName').empty();
                    $('#employeeName').append('<option value="0">-Select-</option>');

                    response.result.forEach(function(employee) {
                        $('#employeeName').append(
                            $('<option></option>').val(employee.employee_id).text(employee.employee_name)
                        );
                    });
                },
                error: function(xhr, status, error) {
                    console.error("Error sending data:");
                }
            });
        }

        function initialize(){
            $.ajax({
               url: './batchDetails',
               method: 'GET',
               dataType: 'json', 
               success: function(response) {
                console.log(response);
                
                $('#batch').empty();
                $('#batch').append('<option value="0">-Select-</option>');
              
                response.result.forEach(function(batch) {
                    $('#batch').append(
                        $('<option></option>').val(batch.batch_id).text(batch.batch_name)
                    );

                    $('#batchSearch').append(
                        $('<option></option>').val(batch.batch_id).text(batch.batch_name)
                    );
                });
                  
               },
               error: function(xhr, status, error) {
                console.error("Error fetching data:");
            }

           });

           $.ajax({
            url: './technologyDetails',
            method: 'GET',
            dataType: 'json', 
            success: function(response) {
             console.log(response);
             $('#technology').empty();
             $('#technology').append('<option value="0">-Select-</option>');

            
             response.result.forEach(function(technology) {
                 $('#technology').append(
                     $('<option></option>').val(technology.technology_id).text(technology.technology_name)
                 );
             });
               
            },
            error: function(xhr, status, error) {
             console.error("Error fetching data:");
         }

        });

        fetchTableData();
       }


       function fetchTableData(batchId=0){
            var postData = {
                batchId: batchId
            };
        $.ajax({
            url: './viewData', 
            method: 'POST',
            contentType: 'application/json', 
            data: JSON.stringify(postData), 
            dataType: 'json',
            success: function(response) {
             console.log(response);
             
             $('#tableView').empty();
                        // Create table structure
            let table = $('<table></table>').addClass('data-table');
            let headerRow = $('<tr></tr>').append(
            '<th>Sl No</th>',
            '<th>Employee Name</th>',
            '<th>Phone</th>',
            '<th>Batch Name</th>',
            '<th>Start Date</th>',
            '<th>Technology</th>',
            '<th>Grade</th>',
            '<th>Marks</th>',
            '<th>Status</th>'
        );

        table.append(headerRow);
        let i=1;
        response.result.forEach(function(item) {
            let row = $('<tr></tr>').append(
                $('<td></td>').text(i++),
                $('<td></td>').text(item.employeeName),
                $('<td></td>').text(item.employeePhone),
                $('<td></td>').text(item.batchName),
                $('<td></td>').text(item.batchStartDate),
                $('<td></td>').text(item.technologyName),
                $('<td></td>').text(item.grade || 'N/A'), 
                $('<td></td>').text(item.mark || 'N/A'), 
                $('<td></td>').text(item.status || 'N/A') 
            );

            table.append(row);
        });

        // Append table to the div
        $('#tableView').append(table);
               
            },
            error: function(xhr, status, error) {
             console.error("Error fetching data:");
         }

        });
       }




    </script>
</body>
</html>



