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
            console.log(this.loginForm);
            this.$refs[formName].validate((valid) => {
                if(valid) {
                    axios.post('/login', this.loginForm, {"headers": {'X-Requested-With': 'XMLHttpRequest'}}).then(function (response) {
                        console.log(response);
                    }).catch(function (error) {
                        console.log(error);
                    });
                    console.log(this.loginForm);
                    //this.$http.post('/login',this.loginForm,)
                    alert('submit!');
                    //console.log(this.$refs[formName]);
                } else {
                    console.log('error submit!!');
            return false;
        }
        });
        }
    }
});