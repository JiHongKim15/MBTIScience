import { Button } from "react-bootstrap";
import ChatHeader from "../components/ChatHeader";
import ChatRoomList from "../components/ChatRoomList";

function ChatRoomListPage() {
    return (
        <div className="ChatRoomListPage">
            <ChatHeader></ChatHeader>
            <ChatRoomList></ChatRoomList>
        </div>
    );
}

export default ChatRoomListPage;