<html>
<head>
    <title>File Uploader</title>
</head>
<body>
<h1>${message}</h1>
</body>

<form method="POST" action="file/upload" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Upload">
</form>
</html>