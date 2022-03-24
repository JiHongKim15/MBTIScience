import React from 'react';
import { Navbar, Nav, Container, Form, Button, FormControl } from "react-bootstrap";

function ChatHeader() {

    return (
        <div className="ChatHeader">
            <>
                <Navbar bg="dark" variant="dark" expand="lg">
                    <Container fluid>
                        <Navbar.Brand href="#">MBTI Chat</Navbar.Brand>
                        <Nav className="me-auto">
                            <Nav.Link href="/">Main</Nav.Link>
                            <Nav.Link href="#">Features</Nav.Link>
                            <Nav.Link href="#">Pricing</Nav.Link>
                        </Nav>
                        <Form className="d-flex">
                            <FormControl
                                type="search"
                                placeholder="Search"
                                className="me-2"
                                aria-label="Search"
                            />
                            <Button variant="outline-light">Search</Button>
                        </Form>
                    </Container>
                </Navbar>
            </>
        </div >
    );
}

export default ChatHeader;