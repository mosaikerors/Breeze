import {combineReducers} from "redux/es/redux";

function Login(state={_id:'',username:'',isManager:0},action) {
    switch (action.type) {
        case "LOGIN":
            return action.result;
        default:
            return state;
    }
}

function Redirect(state={redirectTo:null},action) {
    switch (action.type) {
        case 'REDIRECTED':
            return {redirectTo: null};
        case 'SIGN_UP':
        case 'ADD_BOOK':
        case 'LOGIN':
        case "UPDATE_BOOK":
            return {redirectTo: '/'};
        default:
            return state;

    }
}


export default combineReducers(
    {Login, Redirect}
);