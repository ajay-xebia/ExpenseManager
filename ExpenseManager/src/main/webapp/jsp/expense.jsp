<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

<h3>Expense Manager</h3>
<br>
<form>
	<table class='table table-hover table-responsive table-bordered'>
		<tr>
			<td><b>Amount</b></td>
			<td><input id="amount" type='text' name='amount' class='form-control' required /></td>
		</tr>
		<tr>
			<td><b>From Account</b></td>
			<td>
				<select id="accountName" name="accountName">
				</select>
			</td>
		</tr>
		<tr>
			<td><b>General Expense Category</b></td>
			<td>
				<select id="generalExpenseCategory" name="generalExpenseCategory">
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Core Expense Category</b></td>
			<td>
				<select id="coreExpenseCategory" name="coreExpenseCategory">
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Wallet Refilled</b></td>
			<td>
				<select id="walletRefilled" name="walletRefilled">
				  <option value="true">true</option>
				  <option value="false">false</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><b>Description</b></td>
			<td><input id="description" type='text' name='description' class='form-control'/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button id="add-expense" type="button" class="btn btn-primary">Add Expense</button>
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
	<tbody id="expense-table">
		
	</tbody>
</table>
<script>
$.ajax({url: "/generalExpenseCategories", success: function(result){
	console.log("general: "+result);
    //$("#test").text("result----"+JSON.stringify(result._embedded.generalExpenseCategories));
    var generalExpenseCategories = result._embedded.generalExpenseCategories;
    $.each(generalExpenseCategories, function( index, value ) {
    	  $("#generalExpenseCategory").append("<option name="+value.expenseCategoryTypeName+">"+value.expenseCategoryTypeName+"</option>");
    });
}});

$.ajax({url: "/coreExpenseCategories", success: function(result){
	console.log("core: "+result);
    //$("#test").text("result----"+JSON.stringify(result._embedded.coreExpenseCategories));
    var coreExpenseCategories = result._embedded.coreExpenseCategories;
    $.each(coreExpenseCategories, function( index, value ) {
    	  $("#coreExpenseCategory").append("<option name="+value.categoryName+">"+value.categoryName+"</option>")
    });
}});

$.ajax({url: "/accounts", success: function(result){
	console.log(result);
    //$("#test").text("result----"+JSON.stringify(result._embedded.accounts));
    var accounts = result._embedded.accounts;
    $.each(accounts, function( index, value ) {//console.log(index+": "+JSON.stringify(value));
    	  $("#accountName").append("<option name="+value.accountName+" category="+value.accountCategory+">"+value.accountName+"</option>")
    });
}});

$.ajax({url: "/expenses", success: function(result){
	var expensesAnalytics={};expensesAnalytics["byExpenseTypes"]={};
	expensesAnalytics.byExpenseTypes["monthly"]=0;expensesAnalytics.byExpenseTypes["daily"]=0;
	expensesAnalytics.byExpenseTypes["optional"]=0;expensesAnalytics.byExpenseTypes["unplanned"]=0;
	expensesAnalytics.byExpenseTypes["savings"]=0;
	
	expensesAnalytics["byPaymentTypes"]={};
	expensesAnalytics.byPaymentTypes["credit"]=0;expensesAnalytics.byPaymentTypes["bank"]=0;
	//console.log(result);
    
    var expenses = result._embedded.expenses;
    $.each(expenses, function( index, value ) {//console.log(index+": "+JSON.stringify(value));
    	  $("#expense-table").append("<tr>"+
    			  "<td>"+value.expenseDate+"</td>"+
    			  "<td>"+value.amount+"</td>"+
    			  "<td>"+value.accountName+"</td>"+
    			  "<td>"+value.accountCategory+"</td>"+
    			  "<td>"+value.generalExpenseCategory+"</td>"+
    			  "<td>"+value.coreExpenseCategory+"</td>"+
    			  "<td>"+value.walletRefillFlag+"</td>"+
    			  "<td>"+value.description+"</td>"+"</tr>");
    	  switch(value.generalExpenseCategory){
	    	  case "DAILY":
	    		  expensesAnalytics.byExpenseTypes.daily=expensesAnalytics.byExpenseTypes.daily+value.amount;
	    	  	break;
	    	  case "OPTIONAL":
	    		  expensesAnalytics.byExpenseTypes.optional=expensesAnalytics.byExpenseTypes.optional+value.amount
		  	  	break;
	    	  case "UNPLANNED":
	    		  expensesAnalytics.byExpenseTypes.unplanned=expensesAnalytics.byExpenseTypes.unplanned+value.amount
			  	  break;
	    	  case "MONTHLY":
	    		  expensesAnalytics.byExpenseTypes.monthly=expensesAnalytics.byExpenseTypes.monthly+value.amount
			  	  break;
	    	  case "SAVINGS":
	    		  expensesAnalytics.byExpenseTypes.savings=expensesAnalytics.byExpenseTypes.savings+value.amount
			  	  break;
    	  }
    	  
    });
    $("#test").text("result----> daily: "+expensesAnalytics.byExpenseTypes.daily+
    		", optional: "+expensesAnalytics.byExpenseTypes.optional+
    		", unplanned: "+expensesAnalytics.byExpenseTypes.unplanned+
    		", monthly: "+expensesAnalytics.byExpenseTypes.monthly+
    		", savings: "+expensesAnalytics.byExpenseTypes.savings);
}});

$( "#add-expense" ).click(function() {
	var data={};
	data["expenseDate"]="2018-01-01";
	data["amount"]=$("#amount").val();
	data["accountName"]=$("#accountName").val();
	data["accountCategory"]=$("#accountName :selected").attr("category");
	data["generalExpenseCategory"]=$("#generalExpenseCategory").val();
	data["coreExpenseCategory"]=$("#coreExpenseCategory").val();
	data["walletRefilled"]=$("#walletRefilled").val();
	data["description"]=$("#description").val();
	console.log("data: "+data);
	var url = "/expenses"
	$.ajax({
		type: "POST",
		url: url,
		data: JSON.stringify(data),
		dataType: "application/json",
		contentType: "application/json"
	});
});
</script>
<jsp:include page="footer.jsp"></jsp:include>
