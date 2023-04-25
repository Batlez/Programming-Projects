	<main>	

		<form action="coursebook.php" method="GET">
			<fieldset>
				<legend>Find Books by Title </legend>
				<label for="id">Book Title:</label>
				<input type="text" name="title" id="title"><br>
	
				<input type="submit" name = "action" value="Find Books by Title" >
			</fieldset>
		</form>
		<form action="coursebook.php" method="GET">
			<fieldset>
				<legend>Find Books by Program</legend>
				<label for="program">Program Name:</label>
				<select name = "programCode">
					<option value = ""></option>
					<?php echo $optionList; ?>
				</select>
	
				<input type="submit" name = "action" value="Find Books by Program" >
			</fieldset>
		</form>
		<form action="coursebook.php" method="GET">
			<fieldset>
				<legend>Find Courses by Name </legend>
				<label for="name">Course Name:</label>
				<input type="text" name="name" id="name"><br>
	
				<input type="submit" name = "action" value="Find Courses by Name" >
			</fieldset>
		</form>
		<form action="coursebook.php" method="GET">
			<fieldset>
				<legend>Find Courses by Program</legend>
				<label for="program">Program Name:</label>
				<select name = "programCode">
					<option value = ""></option>
					<?php echo $optionList; ?>
				</select>
	
		<input type="submit" name = "action" value="Find Courses by Program" >
			</fieldset>
		</form>
		
	</main>