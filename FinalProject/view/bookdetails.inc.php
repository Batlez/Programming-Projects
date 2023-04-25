		<main>
			<?php echo $output ?>
			<form action="coursebook.php" method="POST">
			<legend>Comment</legend>
			<textarea name='comment' placeholder='Add a Comment'></textarea>
			<br>
			<Input type="hidden" value="<?php echo $id ?>" name="id">
			<Input type="submit" name="action" value="Submit Comment">
			</form>
		</main>
