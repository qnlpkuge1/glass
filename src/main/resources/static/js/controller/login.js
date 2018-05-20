new Vue({
    el: '#app',
    data: function () {
        return {
            loginForm: {
                username: '',
                password: ''
            },
            rules: {
                username: [
                    {required: true, message: '请输入用户名或手机号码', trigger: 'blur'},
                    {min: 5, max: 14, message: '长度在 5 到 14 个字符', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: '请输入密码', trigger: 'blur'}
                ]
            }
        }
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if(valid) {
                    var loginForm=document.getElementById("loginForm");
                    loginForm.submit();
                } else {
                    return false;
                }
            });
        }
    }
});