
// // Wait for the DOM to be ready
// $(function() {
//
//     // Initialize form validation on the registration form.
//     // It has the name attribute "registration"
//     $("form[name='employeeRegister']").validate({
//         // Specify validation rules
//         rules: {
//             // The key name on the left side is the name attribute
//             // of an input field.Validation rules are defined
//             // on the right side
//             id: {
//                 required: true
//             },
//             name: {
//                 required: true
//             },
//             contact: {
//                 required: true
//             },
//             address: {
//                 required: true
//             },
//         },
//         // Specify validation error messages
//         messages: {
//             id: {
//                 required: "Please enter your ID"
//             },
//             name: {
//                 required: "Please enter your Name"
//             },
//             contact: {
//                 minlength: "Your password must be at least 10 characters long"
//             },
//             address: {
//                 required: "Please enter your address"
//             }
//         },
//         // Make sure the form is submitted to the destination defined
//         // in the "action" attribute of the form when valid
//         submitHandler: function () {
//             form.submit();
//             // event.preventDefault();
//
//         }
//     });
// });

// <script type="text/javascript">
//
//     $(document).ready(function () {
//         jQuery.validator.addMethod("noSpace", function(value, element) {
//             return value == '' || value.trim().length != 0;
//         }, "No space please and don't leave it empty");
//         jQuery.validator.addMethod("id", function(value, element) {
//             return this.optional( element ) || /^(E)[0-9]{1,3}$/.test( value );
//         }, "Please enter valid ID!");
//         jQuery.validator.addMethod("name", function(value, element) {
//             return this.optional( element ) || /^[A-z ]{1,50}$/.test( value );
//         }, "Please enter valid Name!");
//         jQuery.validator.addMethod("contact", function(value, element) {
//             return this.optional( element ) ||/^[0-9]{10,11}$/.test( value );
//         }, "Please enter valid Contact!");
//         jQuery.validator.addMethod("address", function(value, element) {
//             return this.optional( element ) || /^([a-zA-z0-9/\\''(),-s]{2,255})$/.test( value );
//         }, "Please enter valid Address!");
//
//         $('#formUser').validate({
//             rules:{
//
//                 id: {
//                     required: true,
//                     id: true,
//                     noSpace:true
//                 },
//                 //username is the name of the textbox
//                 name: {
//                     required: true,
//                     //alphanumeric is the custom method, we defined in the above
//                     name: true
//                 },
//                 address: {
//                     required: true,
//                     address: true
//                 },
//                 password: {
//                     required: true,
//                     contact: true,
//                     noSpace:true
//                 },
//
//             },
//             messages:{
//
//                 userID: {
//                     //error message for the required field
//                     required: 'Please enter id!',
//                     noSpace: 'Please do not put space!',
//                     userid: 'Please enter valid ID.(Ex:E001)'
//                 },
//                 userNAME: {
//                     required: 'Please enter name!',
//                     userName:'Please enter Valid Name.(Ex:Nimal Perera)'
//                 },
//                 userADDRESS: {
//                     required: 'Please enter Address!',
//                     userAddress:'Please enter Valid Address(Ex:Batapola road,Galle)'
//                 },
//                 userPASSWORD: {
//                     required: 'Please enter Contact!',
//                     noSpace: 'Please do not put space!',
//                     userPassword:'Only 10 or 11 numbers you can use.(Ex:0128569856)'
//                 },
//
//             },
//
//         })
//
//     })
//     </script>