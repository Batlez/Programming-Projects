<?php
	$dsn = 'mysql:host=localhost;dbname=coursebook_db';
	$dbuser = 'root';
	$dbpass = '';
	$db = new PDO($dsn, $dbuser, $dbpass);

function getBookFoundBooksList($books) 
{
	$list="<ul>";
	foreach($books as $book):
		$title = $book['title'];
		$id = $book['id'];
		$list .= "<li><a href='coursebook.php?action=viewbook&id=$id'>$title</a></li>";
	endforeach;
	$list.="</ul>";
	return $list;
}
function getBookFoundCoursesList($courses) 
{
	$list="<ul>";
	foreach($courses as $course):
		$name = $course['name'];
		$id = $course['id'];
		$list .= "<li><a href='coursebook.php?action=viewcourse&id=$id'>$name</a></li>";
	endforeach;
	$list.="</ul>";
	return $list;
}
function getProgramList()
{
	global $db; 
	$optionList="";
 	$query = 'SELECT code, name FROM programs';
	$statement = $db->prepare($query);
	$statement->execute();
	$programs = $statement->fetchAll();
	if($programs != NULL){
		
		foreach($programs as $program):
			$optionList .= "<option value='".$program['code']."'>".$program['name']."</option>";
		endforeach;
	}
	return $optionList;
}

function getProgID($code)
{
	global $db; 
	$query = 'SELECT id FROM programs WHERE code = :code';
	$statement = $db->prepare($query);
	$statement->bindValue(':code', $code);
	$statement->execute();
	$prog = $statement->fetch();
	$statement->closeCursor();
	if($prog != NULL)
		$progID = $prog['id'];
	else
		$progID = 0;
	return $progID;
}
function findBooksByProgram($progID)
{
	global $db; 
	$query = "select b.title, b.id from books b
				join programs_books pb
				ON pb.bookid = b.id
				WHERE pb.programid = :progID;";
	
	$statement = $db->prepare($query);
	$statement->bindValue(':progID', $progID); 
	$statement->execute();
	$books = $statement->fetchAll();
	$statement->closeCursor();
	return $books;	
}
function findCoursesByProgram($progID)
{
	global $db; 
	$query = "select c.name, c.id FROM courses c
				JOIN programs_courses pc
				ON pc.courseid = c.id
				WHERE pc.programid = :progID;";
	
	$statement = $db->prepare($query);
	$statement->bindValue(':progID', $progID); 
	$statement->execute();
	$courses = $statement->fetchAll();
	$statement->closeCursor();
	return $courses;
}
function findBookById($id)
{
	global $db; 
 	$query = 'SELECT * FROM books WHERE id = :id';
	$statement = $db->prepare($query);
	$statement->bindValue(':id', $id);
	$statement->execute();
	$book = $statement->fetch();
	$statement->closeCursor();

	return $book;
}
function findCourseById($id)
{
	global $db; 
	$query = 'SELECT * FROM courses WHERE id = :id';
	$statement = $db->prepare($query);
	$statement->bindValue(':id', $id);
	$statement->execute();
	$course = $statement->fetch();
	$statement->closeCursor();
	return $course;
}
function findBooksByTitle($title)
{
	global $db; 
	$query = "SELECT * FROM books WHERE title LIKE  CONCAT('%', :title, '%')";
	$statement = $db->prepare($query);	
	$statement->bindValue(':title', $title); 
	$statement->execute();
	$books = $statement->fetchAll();
	$statement->closeCursor();
	return $books;
}
function findCoursesByName($name)
{
	global $db; 
	$query = "SELECT * FROM courses WHERE name LIKE CONCAT('%', :name, '%')";
	$statement = $db->prepare($query);
	$statement->bindValue(':name', $name); 
	$statement->execute();
	$courses = $statement->fetchAll();
	$statement->closeCursor();
	return $courses;
}

function editProgram($id, $name) {
    global $db;
    $query = "UPDATE programs SET name = :name WHERE id = :id";
    $statement = $db->prepare($query);
    $statement->bindValue(':name', $name);
    $statement->bindValue(':id', $id);
    $statement->execute();
    $statement->closeCursor();
	return $programs;
}

function delprog($programID) {
    global $db;
    $query = "DELETE FROM programs WHERE id=:id";
    $statement = $db->prepare($query);
    $statement->bindValue(':id', $programID);
    $statement->execute();
    $statement->closeCursor();
}

function findAllPrograms() {
	global $db;
	$query = "SELECT * FROM programs";
	$statement = $db->prepare($query);
	$statement->execute();
	$programs = $statement->fetchAll();
    $statement->closeCursor();
	return $programs;
}

function GetProgramByID($id) {
	global $db;
	$query = "SELECT * FROM programs WHERE id=:id";
	$statement = $db->prepare($query);
	$statement->bindValue(':id', $id);
	$statement->execute();
	$program = $statement->fetch();
	$statement->closeCursor();
	return $program;
}

function UpdateProg($id, $name, $code) {
	global $db;
	$query = "UPDATE programs SET name=:name, code =:code WHERE id=:id";
	$statement = $db->prepare($query);
	$statement->bindValue(':id', $id);
	$statement->bindValue(':name', $name);
	$statement->bindValue(':code', $code);
	$statement->execute();
	$statement->closeCursor();
}

function submitComment($comment, $bookid) {
	global $db;
	$query = "INSERT INTO comments (bookid, comment) values (:bookid, :comment)";
	$statement = $db->prepare($query);
	$statement->bindValue(':bookid', $bookid);
	$statement->bindValue(':comment', $comment);
	$statement->execute();
	$statement->closeCursor();
}

function getCommentsById($bookid) {
	global $db;
	$query = "SELECT * FROM comments WHERE  bookid = :bookid";
	$statement = $db->prepare($query);
	$statement->bindValue(':bookid', $bookid);
	$statement->execute();
	$comments = $statement->fetchAll();
	$statement->closeCursor();
	return $comments;
}
?>