<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="" method="">
    <div class="container">
        <label for="ma"><b>Ma</b></label>
        <input type="text" placeholder="Enter ma" name="maMS" required>
        <br>
        <label for="ten"><b>Ten</b></label>
        <input type="text" placeholder="Enter ten" name="tenMS" required>
        <br>
            <label>Trang Thai</label>

            <div class="form-check">
                <input class="form-check-input" type="radio"  name="trangThai" checked value="Active" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                    Active
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio"  name="trangThai" value="Inactive" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    Inactive
                </label>
            </div>

        <button type="submit">Them</button>
    </div>
</form>
</body>
</html>