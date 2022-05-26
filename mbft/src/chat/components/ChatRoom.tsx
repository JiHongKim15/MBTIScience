import ChatMessage from './ChatMessage';
import { Container, Form, Button } from "react-bootstrap";
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
                <ChatMessage isFriend={true}
                    message="안녕안녕"
                    speaker="지혜" />
                <ChatMessage isFriend={false}
                    message="안녕안녕2"
                />
            </Container>
            <Container style={{
                padding: '0'
            }}>
                <form>
                    <div style={{
                        display: 'inline',
                        fontSize: '25px',
                        fontFamily: 'IBMPlexSansKR-Medium',
                    }}>

                        <input type="text" style={{
                            width: '90%',
                            borderRadius: '10px',
                            border: '4px solid #282828'
                        }}
                            placeholder="메시지를 입력하세요." required></input>


                        <Button variant="primary" type="submit" style={{
                            width: '10%',
                            backgroundColor: '#B90000',
                            border: '1px solid #B90000'
                        }}
                            size='lg'>
                            입력
                        </Button>
                    </div>

                </form>
            </Container>
        </Container >
    );
}

export default ChatRoom;