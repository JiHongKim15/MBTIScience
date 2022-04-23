import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Table, Container } from "react-bootstrap";
import { useHistory } from 'react-router';

function ChatRoomList() {

    const [rooms, setRooms] = useState<any>(null);

    const searchRooms = async () => {
        const url = "/chat/rooms";

        const response = await axios.get(url);
        setRooms(response.data);
    };

    // 해당 메소드는 처음 렌더링 됐을때 실행
    useEffect(() => {
        searchRooms();
    }, []);

    const history = useHistory();
    return (
        <div className="ChatRoomList">
            <Container>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>방제목</th>
                            <th>MBTI</th>
                            <th>방장</th>
                            <th>현재인원</th>
                            <th>최대인원</th>
                            <th>생성시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* optional chaining */}
                        {rooms?.map(room => (
                            <tr key={room.chatRoomId}
                                onClick={() => {
                                    history.push({
                                        pathname: `/chat/room/${room.chatRoomId}`,
                                        state: { room: room }
                                    })
                                }}>
                                <td>{room.chatRoomId}</td>
                                <td>{room.chatSubject}</td>
                                <td>{room.mbti}</td>
                                <td>{room.hostId}</td>
                                <td>{room.num}</td>
                                <td>{room.maxNum}</td>
                                <td>{room.creationTime}</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </Container>

        </div >
    );
}

export default ChatRoomList;