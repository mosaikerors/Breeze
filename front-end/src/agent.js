const requests = require('superagent');

const API_ROOT = 'http://localhost:6180';

const token = "eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6ImFkbWluIiwic3ViIjoidGJjIiwiZXhwIjoxNTYxMTgxMDA5fQ.bzlCdfcGVPlAWx25j3lc4-CalLMu9ntRw_zCi1YfwlA-An2bE3xZe-YahBsJqB8isRNJYbBvzFLtMr0yVOuYlA";

const token_requests = {
    get: (url)=>requests.get(API_ROOT+url).set('Authorization', 'Bearer ' + token).then(res => res.body),
    getWith:(url,body)=>requests.get(API_ROOT+url,{params: body}).set('Authorization', 'Bearer ' + token).then(res => res.body),
    post:(url,body)=>requests.post(API_ROOT+url,body).set('Authorization', 'Bearer ' + token).then(res => res.body),
    delete:(url,body)=>requests.delete(API_ROOT+url,body).set('Authorization', 'Bearer ' + token).then(res => res.body),
    put:(url,body)=>requests.put(API_ROOT+url,body).set('Authorization', 'Bearer ' + token).then(res => res.body)
};

const User = {
    showAll: (/*token*/) => {
        requests.get(API_ROOT + '/admin/showAll')
            .set('Authorization', 'Bearer ' + token)
            .then(res => res.body)
    },
    login: (phone, password) => requests.post('/api/user/login').send({"phone":phone, "password": password}).then(res => res.body),
    signup: (username, password, phone) => requests.post('/api/user/signup').send({"username":username, "password": password,
        "phone": phone}).then(res => res.body)
}

const Hean = {
    showAll: () => {
        requests.post(API_ROOT + '/hean/search/byTime')
            .set('Authorization', 'Bearer ' + token)
            .send({
                beginTime: "2019-1-1",
                endTime: "2019-12-31"
            })
            .then(res => res.body)
    }
}

export {
    User,
    Hean
}
