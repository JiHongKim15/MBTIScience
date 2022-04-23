import ChatMessage from './ChatMessage';
import { Container, Row, Col, ToastContainer, Toast, ToastBody } from "react-bootstrap";

function ChatRoom() {

    return (
        <Container className="ChatRoom"
            style
            ={{
                position: 'relative',
                display: 'block',
                width: '40%',
                overflowY: "auto",
                backgroundColor: '#FDF5D2',
                minHeight: '700px',
                borderRadius: '10px'
            }}

        >
            <ChatMessage isFriend={true}></ChatMessage>
            <ChatMessage isFriend={false}></ChatMessage>
        </Container >
    );
}

export default ChatRoom;