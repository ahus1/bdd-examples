var app = new Vue({
    el: '#app',
    data: {
        state: null,
        error: null
    },
    methods: {
        refresh: function () {
            this.error = null
            var model = this
            axios.get('api')
                .then(function (response) {
                    model.state = response.data.state
                })
                .catch(function (error) {
                    model.error = 'Can\'t read value: ' + error
                });
        },
        increment: function () {
            this.error = null;
            var model = this
            axios.post('api/increment')
                .then(function (response) {
                    model.refresh()
                })
                .catch(function (error) {
                    model.error = 'Can\'t increment: ' + error
                });
        },
        reset: function () {
            this.error = null;
            var model = this
            axios.post('api/reset')
                .then(function (response) {
                    model.refresh()
                })
                .catch(function (error) {
                    model.error = 'Can\'t reset: ' + error
                });
        }
    },
    created: function () {
        this.refresh()
    }
})