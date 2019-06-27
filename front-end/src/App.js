import React from 'react';
import { Button, TextField } from '@material-ui/core';
import agent from './agent';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            phone: '',
            password: '',
            token: '',
            heans: [],
            users: [],
        }
        this.handleClickHean = this.handleClickHean.bind(this);
        this.handleClickUser = this.handleClickUser.bind(this);
        this.handleClickLogin = this.handleClickLogin.bind(this);
        this.handlePhoneChange = this.handlePhoneChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
    }

    handleClickHean() {
        this.setState({
            heans: agent.Hean.showAll(this.state.token),
            users: []
        })
    }

    handleClickUser() {
        this.setState({
            users: agent.User.showAll(this.state.token),
            heans: []
        })
    }

    handleClickLogin() {
        const resp = agent.User.login(this.state.phone, this.state.password);
        console.log(resp.token);
        this.setState({
            token: resp.token
        })
    }

    handlePhoneChange(event) {
        this.setState({
            phone: event.target.value,
        })
    }

    handlePasswordChange(event) {
        this.setState({
            password: event.target.value,
        })
    }

    render() {
        return (
            <React.Fragment>
                <TextField
                    label='phone'
                    value={this.state.phone}
                    onChange={this.handlePhoneChange}
                />
                <br />
                <TextField
                    label='password'
                    value={this.state.password}
                    onChange={this.handlePasswordChange}
                />
                <br />
                <br />
                <Button
                    variant='contained'
                >
                    login
                </Button>
                <br />
                <br />
                <Button
                    variant='contained'
                    onClick={this.handleClickHean}
                >
                    show heans
                </Button>
                <br />
                <br />
                <Button
                    variant='contained'
                    onClick={this.handleUserHean}
                >
                    show users
                </Button>
                <div>
                    {this.state.heans.map(hean => 
                        <div>
                            <p>userId:{hean.userId}</p>
                            <p>content:{hean.content}</p>
                            <p>appendix:{hean.appendix}</p>
                        </div>
                    )}
                </div>
                <div>
                    {this.state.users.map(user => 
                        <div>
                            <p>phone:{user.phone}</p>
                            <p>status:{user.status}</p>
                        </div>
                    )}
                </div>
            </React.Fragment>
        );
    }
}

export default App;
