import React from 'react';
import { Button, TextField } from '@material-ui/core';
import agent from './agent';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            heans: [],
            users: []
        }
        this.handleClickHean = this.handleClickHean.bind(this);
        this.handleClickUser = this.handleClickUser.bind(this);
    }

    handleClickHean() {
        this.setState({
            heans: agent.Hean.showAll(),
            users: []
        })
    }

    handleClickUser() {
        this.setState({
            users: agent.User.showAll(),
            heans: []
        })
    }

    render() {
        return (
            <React.Fragment>
                <Button
                    variant='contained'
                >
                    login
                </Button>
                <TextField
                    label='phone'
                />
                <Button
                    variant='contained'
                    onClick={this.handleClickHean}
                >
                    show heans
                </Button>
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
                            <p>phone:{hean.phone}</p>
                            <p>status:{hean.status}</p>
                        </div>
                    )}
                </div>
            </React.Fragment>
        );
    }
}

export default App;
