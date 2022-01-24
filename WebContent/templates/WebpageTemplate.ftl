<#include "header.ftl">

<b>Welcome to Movie Rating App</b><br><br>

<form method="POST" action="rugui?action=add">
	<fieldset id="getMovies">
		<legend>Required Information</legend>
		<div>
			<label>Title</label>
			<input type="text" name="title" >
	    </div>

		<div>
			<label> Director</label>
			<input type="text" name="director"  >
	    </div>

		<div>
			<label>Actors</label>
			<input type="text" name="actors">
	    </div>
	        
	        <div>
		        <label>Publishing Date</label>
			<input type="text" name="publishingDate" id="datepicker1">
	   </div>
	    
	    
	</fieldset>
	<button type="submit" id="submit">Submit</button>
</form>
<#include "footer.ftl">
