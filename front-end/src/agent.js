const requests = require('superagent');

const API_ROOT = 'http://localhost:6180';

const token = "eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6ImFkbWluIiwic3ViIjoidGJjIiwiZXhwIjoxNTYxMTgxMDA5fQ.bzlCdfcGVPlAWx25j3lc4-CalLMu9ntRw_zCi1YfwlA-An2bE3xZe-YahBsJqB8isRNJYbBvzFLtMr0yVOuYlA";

const User = {
    showAll: (/*token*/) => {
        requests.get(API_ROOT + '/admin/showAll')
            .set('Authorization', 'Bearer ' + token)
            .then(res => res.body)
    },
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

export default {
    User,
    Hean
}
