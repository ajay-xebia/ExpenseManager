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
				<select name="accountId">
				  <option value="Food&Others">AMEX</option>
				  <option value="Travel">ICICI</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><b>Expense Category</b></td>
			<td>
				<select name="expenseCategory">
				  <option value="MONTHLY">MONTHLY</option>
				  <option value="DAILY">DAILY</option>
				  <option value="OPTIONAL">OPTIONAL</option>
				  <option value="UNPLANNED">UNPLANNED</option>
				  <option value="SAVINGS">SAVINGS</option>
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Expense Sub Category</b></td>
			<td>
				<select name="expenseSubCategory">
				  <option value="Food&Others">Food&Others</option>
				  <option value="Travel">Travel</option>
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Payment Category</b></td>
			<td>
				<select name="paymentCategory">
				  <option value="CreditCard">CreditCard</option>
				  <option value="Debit">Debit</option>
				  <option value="Cash">Cash</option>
				  <option value="Wallet">Wallet</option>
				  <option value="Savings">Savings</option>
				</select>
			</td>

		</tr>
		<tr>
			<td><b>Payment Sub Category</b></td>
			<td>
				<select name="paymentSubCategory">
				  <option value="AMEX">AMEX</option>
				  <option value="ICICI">ICICI</option>
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
				<button type="submit" class="btn btn-primary">Add Expense</button>
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
			<th><b>Expense Category</b></th>
			<th><b>Expense Sub Category</b></th>
			<th><b>Description</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tbody>
</table>
<script>
$.ajax({url: "/generalExpenseCategories", success: function(result){
	console.log(result);
    $("#test").text(result);
}});
</script>
<!--

//-->
</script>
<jsp:include page="footer.jsp"></jsp:include>
