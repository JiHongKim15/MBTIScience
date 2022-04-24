import { Button } from "react-bootstrap";
import ChatHeader from "../components/ChatHeader";
import ChatRoom from "../components/ChatRoom";

function ChatRoomPage() {
    return (
        <div className="ChatRoomPage">
            <ChatHeader></ChatHeader>
            <ChatRoom></ChatRoom>
        </div>
    );
}

export default ChatRoomPage;