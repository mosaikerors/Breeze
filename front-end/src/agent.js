const requests = require('superagent');

const API_ROOT = 'http://localhost:6180';

const User = {
    showAll: (token) => {
        requests.get(API_ROOT + '/admin/showAll')
            .set('Authorization', 'Bearer ' + token)
            .then(res => res.body)
    },
    login: (phone, password) =>
        requests.post('/user/login')
            .send({ phone, password })
            .then(res => res.body)
}

const Hean = {
    showAll: (token) => {
        requests.post(API_ROOT + '/hean/search/byTime')
            .set('Authorization', 'Bearer ' + token)
            .send({
                beginTime: "2019-1-1",
                endTime: "2019-12-31"
            })
            .then(res => res.body)
    }
}

export default {
    User,
    Hean
}
