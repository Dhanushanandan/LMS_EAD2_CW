document.addEventListener('DOMContentLoaded', () => {
    // Fetch and display data on page load
    fetchBooks();
    fetchMembers();
    fetchMemberships();

    // Add event listeners for form submissions
    document.getElementById('book-form').addEventListener('submit', handleBookForm);
    document.getElementById('member-form').addEventListener('submit', handleMemberForm);
    document.getElementById('membership-form').addEventListener('submit', handleMembershipForm);
});

// Fetch and display books
function fetchBooks() {
    fetch('http://localhost:8080/LMS/Books')
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            const booksList = document.getElementById('books-list');
            booksList.innerHTML = '';
            data.forEach(book => {
                const li = document.createElement('li');
                li.textContent = `ID: ${book.id}, Title: ${book.title}, Author: ${book.author}`;
                booksList.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching books:', error));
}

// Handle book form submission for Add or Delete
function handleBookForm(event) {
    event.preventDefault();
    const action = event.submitter.dataset.action;

    const bookId = document.getElementById('book-id').value.trim();
    const bookTitle = document.getElementById('book-title').value.trim();
    const bookAuthor = document.getElementById('book-author').value.trim();

    if (action === 'Add OR Update Book') {
        const newBook = { id: bookId, title: bookTitle, author: bookAuthor };
        fetch('http://localhost:8080/LMS/Books', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newBook)
        })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                return response.json();
            })
            .then(() => {
                fetchBooks();
                displayMessage(`Book ${bookId} added/updated successfully!`);
                document.getElementById('book-form').reset();
            })
            .catch(error => console.error('Error adding/updating book:', error));
    } else if (action === 'Delete Book') {
        fetch(`http://localhost:8080/LMS/Books/${bookId}`, { method: 'DELETE' })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                fetchBooks();
                displayMessage(`Book ${bookId} deleted successfully!`);
                document.getElementById('book-form').reset();
            })
            .catch(error => console.error('Error deleting book:', error));
    }
}

// Fetch and display members
function fetchMembers() {
    fetch('http://localhost:8080/LMS/Member')
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            const membersList = document.getElementById('members-list');
            membersList.innerHTML = '';
            data.forEach(member => {
                const li = document.createElement('li');
                li.textContent = `ID: ${member.id}, Name: ${member.name}, Email: ${member.email}, Phone: ${member.phone}`;
                membersList.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching members:', error));
}

// Handle member form submission for Add or Delete
function handleMemberForm(event) {
    event.preventDefault();
    const action = event.submitter.dataset.action;

    const memberId = document.getElementById('member-id').value.trim();
    const memberName = document.getElementById('member-name').value.trim();
    const memberEmail = document.getElementById('member-email').value.trim();
    const memberPhone = document.getElementById('member-phone').value.trim();

    if (action === 'Add OR Update Member') {
        const newMember = { id: memberId, name: memberName, email: memberEmail, phone: memberPhone };
        fetch('http://localhost:8080/LMS/Member', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newMember)
        })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                return response.json();
            })
            .then(() => {
                fetchMembers();
                displayMessage(`Member ${memberId} added/updated successfully!`);
                document.getElementById('member-form').reset();
            })
            .catch(error => console.error('Error adding/updating member:', error));
    } else if (action === 'Delete Member') {
        fetch(`http://localhost:8080/LMS/Member/${memberId}`, { method: 'DELETE' })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                fetchMembers();
                displayMessage(`Member ${memberId} deleted successfully!`);
                document.getElementById('member-form').reset();
            })
            .catch(error => console.error('Error deleting member:', error));
    }
}

// Fetch and display memberships
function fetchMemberships() {
    fetch('http://localhost:8080/LMS/Membership')
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            const membershipsList = document.getElementById('memberships-list');
            membershipsList.innerHTML = '';
            data.forEach(membership => {
                const li = document.createElement('li');
                li.textContent = `ID: ${membership.id}, Member ID: ${membership.m_id}, End Date: ${membership.membership_end}`;
                membershipsList.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching memberships:', error));
}

// Handle membership form submission for Add or Delete
function handleMembershipForm(event) {
    event.preventDefault();
    const action = event.submitter.dataset.action;

    const membershipId = document.getElementById('membership-id').value.trim();
    const membershipMemberId = document.getElementById('membership-member-id').value.trim();
    const membershipEndDate = document.getElementById('membership-end').value.trim();

    if (action === 'Add OR Update Membership') {
        const newMembership = { id: membershipId, m_id: membershipMemberId, membership_end: membershipEndDate };
        fetch('http://localhost:8080/LMS/Membership', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newMembership)
        })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                return response.json();
            })
            .then(() => {
                fetchMemberships();
                displayMessage(`Membership ${membershipId} added/updated successfully!`);
                document.getElementById('membership-form').reset();
            })
            .catch(error => console.error('Error adding/updating membership:', error));
    } else if (action === 'Delete Membership') {
        fetch(`http://localhost:8080/LMS/Membership/${membershipId}`, { method: 'DELETE' })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                fetchMemberships();
                displayMessage(`Membership ${membershipId} deleted successfully!`);
                document.getElementById('membership-form').reset();
            })
            .catch(error => console.error('Error deleting membership:', error));
    }
}

// Function to display messages
function displayMessage(message) {
    const messageContainer = document.createElement('div');
    messageContainer.textContent = message;
    document.body.appendChild(messageContainer);
    setTimeout(() => {
        document.body.removeChild(messageContainer);
    }, 3000);
}
