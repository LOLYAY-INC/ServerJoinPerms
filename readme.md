# ServerJoinPerms

A Velocity proxy plugin that enforces server-specific join permissions for Minecraft servers.

## Features

- Restricts players from joining servers they don't have permission for
- Prevents server switching to unauthorized servers
- Simple permission-based access control
- Native Velocity integration

## Requirements

- Velocity 3.0.0 or higher
- Java 11 or higher

## Installation

1. Download the latest `ServerJoinPerms.jar` from the releases page
2. Place the JAR file in your Velocity server's `plugins` directory
3. Restart your Velocity proxy

## Usage

### Permissions

The plugin uses a simple permission structure:
- `server.<servername>` - Grants permission to join the specified server

### Examples

- To allow access to a server named `survival`: `server.survival`
- To allow access to a server named `creative`: `server.creative`

### Behavior

- Players without the required permission will be disconnected with an error message
- Permission checks occur on both initial join and server transfers
- The error message clearly indicates the reason for disconnection

## Configuration

No configuration file is needed. The plugin works out of the box with Velocity's permission system.

## Building from Source

1. Clone the repository
2. Run `mvn clean package`
3. Find the compiled JAR in the `target` directory

## Support

For support, please open an issue on the GitHub repository.

## License

This project is licensed under the MIT License.

## Author

- **LOLYAY** - Initial development