<?php 
include('model/functions.inc.php');

$action = filter_input(INPUT_POST, 'action');
if($action == NULL)
	$action = filter_input(INPUT_GET, 'action');

if($action == "Find Books by Program")
{ 
	$programCode = filter_input(INPUT_GET, 'programCode');
	$progID = getProgID($programCode);
	if($progID > 0)
	{
		$books = findBooksByProgram($progID);
		if($books != NULL)
		{
			$output = "<h2>Books Found:</h2>";
			$output .= getBookFoundBooksList($books);	
		}
		else
			$output = "<h2> No matching books found</h2>";			
	}
	else
		$output = "<h2> Invalid Program</h2>";
	
	$title = "CourseBook - Book List";
	include('view/header.inc.php');
	include('view/booklist.inc.php');
	include('view/footer.inc.php');
}
elseif($action == "Find Courses by Program")
{ 
	$programCode = filter_input(INPUT_GET, 'programCode');
	$progID = getProgID($programCode);
	if($progID > 0)
	{
		$courses = findCoursesByProgram($progID);
		if($courses != NULL)
		{
			$output = "<h2>Courses Found:</h2>";
			$output .= getBookFoundCoursesList($courses);	
		}
		else
			$output = "<h2> No matching courses found</h2>";
	}
	else
			$output = "<h2> Invalid Program</h2>";

	$title = "CourseBook - Book List";
	include('view/header.inc.php');
	include('view/booklist.inc.php');
	include('view/footer.inc.php');
}
elseif ($action == "Find Books by Title")
{
	$title = trim(filter_input(INPUT_GET, 'title'));
	$books = findBooksByTitle($title);
	if($books != NULL)
	{
		$output = "<h2>Books Found:</h2>";
		$output .= getBookFoundBooksList($books);		
	}
	else
		$output = "<h2> No matching books found</h2>";
	
	$title = "CourseBook - Book List";
	include('view/header.inc.php');
	include('view/booklist.inc.php');
	include('view/footer.inc.php');
	
}
elseif ($action == "Find Courses by Name")
{
	$name = trim(filter_input(INPUT_GET, 'name'));
	$courses = findCoursesByName($name);
	if($courses != NULL)
	{
		$output = "<h2>Courses Found:</h2>";
		$output .= getBookFoundCoursesList($courses);	
	}
	else
		$output = "<h2> No matching courses found</h2>";
	
	$title = "CourseBook - Course List";
	include('view/header.inc.php');
	include('view/courselist.inc.php');
	include('view/footer.inc.php');
}
elseif($action == "viewbook")
{
	$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);
	$book = findBookById($id);
	
	if($book != NULL)
	{
		$title = $book['title'];
		$authors = $book['authors'];
		$isbn = $book['isbn'];
		$output = "<h2> $title </h2>";
		$output .= "<p>Authors: $authors <br>ISBN:  $isbn </p>";
	}
	else
		$output = "<h2> No matching book found</h2>";
	
	$comments = getCommentsById($id);
	    if ($comments != NULL) {
      foreach ($comments as $comment):
    $com = $comment['comment'];
    $output .= "<p> $com </p>";
	
	endforeach;
    }
	else
		{
        $output .= "<p>No comments found.</p>";
    }
	
	$title = "CourseBook - Book Details";
	include('view/header.inc.php');
	include('view/bookdetails.inc.php');
	include('view/footer.inc.php');
}
elseif($action == "viewcourse")
{
	$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);
	$course = findCourseById($id);
	if($course != NULL)
	{
		$name = $course['name'];
		$code = $course['code'];
		$description = $course['description'];
		$output = "<h2> $name </h2>";
		$output .= "<p>Course Code: $code <br>Description:  $description </p>";	
	}
	else
		$output = "<h2> No matching Course found</h2>";
	$title = "CourseBook - Course Details";
	include('view/header.inc.php');
	include('view/coursedetails.inc.php');
	include('view/footer.inc.php');
}
elseif($action == "Edit Program") {
	
	$id = filter_input (INPUT_POST, 'id');
	$name = filter_input (INPUT_POST, 'name');
	$code = filter_input (INPUT_POST, 'code');
	
	UpdateProg($id, $name, $code);
	header('location: coursebook.php?action=proglist');
}
elseif ($action == "proglist") {
    $programs = findAllPrograms();
	$output = "<h2>All Programs</h2>";
    if ($programs != NULL) {
      foreach ($programs as $program) :
    $name = $program['name'];
    $id = $program['id'];
    $output .= "<a href=coursebook.php?action=displayprog&id=$id>$name</a> |
		<a href=coursebook.php?action=editprog&id=$id>Edit</a> |
		<a href=coursebook.php?action=delprog&id=$id>Delete</a><br>";
	
	endforeach;
    }
	else
		{
        $output .= "No programs found.";
    }
	
	$title = "All Programs";
	include('view/header.inc.php');
	include('view/allprog.inc.php');
	include('view/footer.inc.php');
	
}

elseif ($action == "delprog") {
	$id = filter_input(INPUT_GET, 'id');
	delprog($id);
	header('location: coursebook.php?action=proglist');
}
elseif ($action == "editprog") {
	$id = filter_input(INPUT_GET, 'id');
	$program = GetProgramByID($id);
	
	$name = $program['name'];
	$code = $program['code'];
	
	$title = "Edit $name";
	include('view/header.inc.php');
	include('view/editprog.inc.php');
	include('view/footer.inc.php');
}
elseif($action == "Submit Comment") {
	$comment = filter_input(INPUT_POST, 'comment');
	$bookid = filter_input(INPUT_POST, 'id');
	
	submitComment($comment, $bookid);
	header("location: coursebook.php?action=viewbook&id=$bookid");
}

elseif ($action == "coursedetails") {
    $output = "<h2>No matching Program found</h2>";
    $title = "CourseBook - Course Details";
    include('view/header.inc.php');
    include('view/coursedetails.inc.php');
    include('view/footer.inc.php');
} else {
    $optionList = getProgramList();
    $title = "CourseBook - All your course and book are belong to us";
    include('view/header.inc.php');
    include('view/homepage.inc.php');
    include('view/footer.inc.php');
} 
?>