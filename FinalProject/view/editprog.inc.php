<main>
  <h2><?php echo $name ?></h2>
  <form action="coursebook.php" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<?php echo $name ?>">
	<br>
	<label for="code">Code:</label>
    <input type="text" id="code" name="code" value="<?php echo $code ?>">
    <br>
	<Input type="hidden" name="id" value="<?php echo $id ?>">
    <Input type="submit" name="action" value="Edit Program">
  </form>
</main>
</html>
