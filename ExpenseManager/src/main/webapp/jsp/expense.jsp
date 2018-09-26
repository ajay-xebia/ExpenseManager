<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

<h3>Expense Manager</h3>
<br>
<form action='/index/add' method='post'>
	<table class='table table-hover table-responsive table-bordered'>
		<tr>
			<td><b>Amount</b></td>
			<td><input type='text' name='name' class='form-control' required /></td>
		</tr>
		<tr>
			<td><b>From Account</b></td>
			<td>
				<select id="accounts" name="accounts">
				</select>
			</td>
		</tr>
		<tr>
			<td><b>General Expense Category</b></td>
			<td>
				<select id="generalExpenseCategories" name="generalExpenseCategories">
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Core Expense Category</b></td>
			<td>
				<select id="coreExpenseCategories" name="coreExpenseCategories">
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Wallet Refilled</b></td>
			<td>
				<select name="walletRefilled">
				  <option value="true">true</option>
				  <option value="false">false</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button id="add-expense" type="submit" class="btn btn-primary">Add Expense</button>
			</td>
		</tr>
	</table>
</form>

<h3>List Of Expenses</h3>
<br>
<div id="test"></div>
<table class="table table-hover">
	<thead>
		<tr>
			<th><b>Date</b></th>
			<th><b>Amount</b></th>
			<th><b>Account</b></th>
			<th><b>AccountCategory</b></th>
			<th><b>General</b></th>
			<th><b>Core</b></th>
			<th><b>WalletRefilled</b></th>
			<th><b>Description</b></th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
<script>
$.ajax({url: "/generalExpenseCategories", success: function(result){
	console.log(result);
    //$("#test").text("result----"+JSON.stringify(result._embedded.generalExpenseCategories));
    var generalExpenseCategories = result._embedded.generalExpenseCategories;
    $.each(generalExpenseCategories, function( index, value ) {
    	  $("#generalExpenseCategories").append("<option name="+value.expenseCategoryTypeName+">"+value.expenseCategoryTypeName+"</option>")
    });
}});

$.ajax({url: "/coreExpenseCategories", success: function(result){
	console.log(result);
    //$("#test").text("result----"+JSON.stringify(result._embedded.coreExpenseCategories));
    var coreExpenseCategories = result._embedded.coreExpenseCategories;
    $.each(coreExpenseCategories, function( index, value ) {
    	  $("#coreExpenseCategories").append("<option name="+value.categoryName+">"+value.categoryName+"</option>")
    });
}});

$.ajax({url: "/accounts", success: function(result){
	console.log(result);
    //$("#test").text("result----"+JSON.stringify(result._embedded.accounts));
    var accounts = result._embedded.accounts;
    $.each(accounts, function( index, value ) {console.log(index+": "+JSON.stringify(value));
    	  $("#accounts").append("<option name="+value.accountName+">"+value.accountName+"</option>")
    });
}});

$.ajax({url: "/expenses", success: function(result){
	console.log(result);
    $("#test").text("result----"+JSON.stringify(result._embedded.expenses));
    var expenses = result._embedded.expenses;
    $.each(expenses, function( index, value ) {console.log(index+": "+JSON.stringify(value));
    	  //$("#accounts").append("<option name="+value.accountName+">"+value.accountName+"</option>")
    });
}});

$( "#add-expense" ).click(function() {
	var data={};
	var url = "/expenses"
	$.ajax({
		type: "POST",
		url: url,
		data: JSON.stringify(data),
		dataType: "application/json",
		contentType: "application/json"
	}
});
	
}
</script>
<jsp:include page="footer.jsp"></jsp:include>
