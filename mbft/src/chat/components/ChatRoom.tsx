import ChatMessage from './ChatMessage';
import { Container, Row, Col, ToastContainer, Toast, ToastBody } from "react-bootstrap";
import { useLocation } from "react-router-dom";

interface Ilocation {
    room: any
}

function ChatRoom() {
    const location = useLocation<Ilocation>();
    const room = location.state.room;

    return (
        <Container className="ChatRoom"
            style={{
                width: '60%'
            }}>
            <Container
                style={{
                    fontSize: '30px',
                    fontFamily: 'IBMPlexSansKR-Medium',
                    backgroundColor: '#FFC31E',
                    textAlign: 'left',
                    display: 'inline',
                    float: 'left'
                }}>
                {/* https://dreamyguy.github.io/react-emojis/ */}
                <span role="img" aria-label="sparkles">✨</span>
                <span>{room.chatSubject}</span>
                <span style={{ float: 'right' }}>{room.mbti}</span>
            </Container>
            <Container
                style
                ={{
                    position: 'relative',
                    display: 'block',
                    overflowY: "auto",
                    backgroundColor: '#FDF5D2',
                    minHeight: '700px',

                }}

            >
                <ChatMessage isFriend={true}></ChatMessage>
                <ChatMessage isFriend={false}></ChatMessage>
            </Container>
        </Container >
    );
}

export default ChatRoom;