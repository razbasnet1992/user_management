<!DOCTYPE html>
<html>
<head>
    <script>

        // Function to check Whether both passwords
        // is same or not.
        function checkPassword(form) {
            password1 = form.password1.value;
            password2 = form.password2.value;

            // If password not entered
            if (password1 == '')
                alert ("Please enter Password");

            // If confirm password not entered
            else if (password2 == '')
                alert ("Please enter confirm password");

            // If Not same return False.
            else if (password1 != password2) {
                alert ("\nPassword did not match: Please try again...")
                return false;
            }

            // If same return True.
            else{
                alert("Password Match: Welcome to User Management!")
                return true;
            }
        }
    </script>
    <style>
        .gfg {
            font-size:20px;
            color:green;
            font-weight:bold;
            text-align:center;
        }
        .geeks {
            font-size:20px;
            text-align:center;
            margin-bottom:20px;
        }
        .invalid_token{
            font-size:15px;
            text-align:center;
            margin-bottom:20px;
            color:red;
        }
    </style>
</head>
<body>
<div class = "gfg">USER MANAGEMENT</div>
<div class = "geeks">RESET PASSWORD</div>
<form action = "/reset_password" method = "post" onSubmit = "return checkPassword(this)">
    <input type="hidden" name="token" value="${token}" />

    <div class = "invalid_token">${invalid_token}</div>

    <table border = 1 align = "center">

        <tr>
            <!-- Enter Password. -->
            <td>Password:</td>
            <td><input type = password name = password1 size = 25</td>
        </tr>
        <tr>
            <!-- To Confirm Password. -->
            <td>Confirm Password:</td>
            <td><input type = password name = password2 size = 25></td>
        </tr>
        <tr>
            <td colspan = 2 align = right>
                <input type = submit value = "Change Password"></td>
        </tr>
    </table>
</form>
</body>
</html>                  