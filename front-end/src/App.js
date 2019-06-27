import React from 'react';
import { Button, TextField, Divider } from '@material-ui/core';
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

    async handleClickHean() {
        const resp = await agent.Hean.showAll(this.state.token);
        console.log(resp.heans);
        this.setState({
            heans: resp === 500 ? ["Login please"] : resp.heans,
            users: []
        })
    }

    async handleClickUser() {
        const resp = await agent.User.showAll(this.state.token);
        console.log(resp)
        this.setState({
            users: resp === 500 ? ["Login please"] : resp.users,
            heans: []
        })
    }

    async handleClickLogin() {
        console.log(await agent.User.login(this.state.phone, this.state.password))
        const resp = await agent.User.login(this.state.phone, this.state.password);
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
                    onClick={this.handleClickLogin}
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
                    onClick={this.handleClickUser}
                >
                    show users
                </Button>
                <div>
                    {this.state.heans.length === 1 ? <p>Login please</p> :
                        this.state.heans.map(hean =>
                            <div>
                                <p>userId:{hean.userId}</p>
                                <p>content:{hean.content}</p>
                                <p>appendix:{hean.position}</p>
                                <Divider />
                            </div>
                        )}
                </div>
                <div>
                    {this.state.users.length === 1 ? <p>Login please</p> :
                        this.state.users.map(user =>
                            <div>
                                <p>phone:{user.phone}</p>
                                <p>status:{user.status}</p>
                                <Divider />
                            </div>
                        )}
                </div>
            </React.Fragment>
        );
    }
}

export default App;
